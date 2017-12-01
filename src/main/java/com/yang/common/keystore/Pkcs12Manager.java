package com.yang.common.keystore;

import com.yang.common.modules.string.StringPool;
import org.bouncycastle.openssl.MiscPEMGenerator;
import org.bouncycastle.openssl.PEMWriter;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.io.pem.PemHeader;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemObjectGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.x509.CertificateValidity;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

import java.io.*;
import java.security.*;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;

public class Pkcs12Manager {
    private static Logger log = LoggerFactory.getLogger(Pkcs12Manager.class);

    public File file;
    public KeyStore keyStore;
    private char[] storePass;
    private String alias;
    private StringBuffer sb;

    public Pkcs12Manager(File file, String pass) throws IOException, Exception {
        this.file = file;
        this.storePass = pass.toCharArray();
        getKeyStore(); // 加载 KeyStore 文件
    }

    /**
     * 加载 KeyStore 文件
     * @return
     * @throws IOException
     * @throws Exception
     */
    public synchronized KeyStore getKeyStore() throws IOException, Exception {
        if (keyStore == null) {
            FileInputStream fin = new FileInputStream(file);
            KeyStore store = KeyStore.getInstance(KeyStore.getDefaultType());
            try {
                store.load(fin, storePass);

                Enumeration enumeration = store.aliases();
                while(enumeration.hasMoreElements()) {
                    alias = (String)enumeration.nextElement();
//                    System.out.println("alias name:" + alias);
//                    Certificate certificate = store.getCertificate(alias);
//                    System.out.println(new String(certificate.getEncoded()));
                }

            } finally {
                try {
                    fin.close();
                } catch (IOException e) {
                }
            }
            keyStore = store;
        }
        return keyStore;
    }

    /**
     * 读取 alias 指定的证书内容
     * @return
     * @throws Exception
     */
    public X509CertInfo getX509CertInfo() throws Exception {
        X509CertImpl cimp = getX509CertImpl();
        // 获取 X509CertInfo 对象
        return (X509CertInfo) cimp.get(X509CertImpl.NAME + "." + X509CertImpl.INFO);
    }

    /**
     * 根据 alias 获取 X509CertImpl 对象
     * @return
     * @throws Exception
     */
    private X509CertImpl getX509CertImpl() throws Exception {
        Certificate c = keyStore.getCertificate(alias); // 读取证书
        // 从待签发的证书中提取证书信息　　
        byte[] enc = c.getEncoded(); // 获取 证书内容（经过编码的字节）
        X509CertImpl cimp = new X509CertImpl(enc); // 创建 X509CertImpl 象
        return cimp;
    }

    /**
     * 获取BundleId
     *      C=US, O="Shanghai Visionet lnformation Technology Corp.,Ltd.", OU=RSS58UZ4J5, CN=Apple Push Services: com.visionet.inhouse.UseWskSDKProj, UID=com.visionet.inhouse.UseWskSDKProj
     * @return
     * @throws Exception
     */
    public String getUid() throws Exception{
        String subjectDN = this.getX509CertImpl().getSubjectDN().getName();
        if(subjectDN.contains("UID=")){
            subjectDN = subjectDN.substring(subjectDN.lastIndexOf("UID=")+4);
        }
        return subjectDN;
    }

    /**
     * 修改证书过期时间 : 过期时间顺延 n 天
     * @param keypass
     * @param n
     * @throws Exception
     */
    public void updateExpiration(String keypass, int n) throws Exception {
//        System.out.println(getExpiration());
        X509CertInfo cinfo = getX509CertInfo(); // 获取 X509CertInfo 对象
        X509CertImpl cimp = getX509CertImpl(); // 获取 X509CertImpl 对象
        String sigAlgrithm = cimp.getSigAlgName(); // 获取签名算法
        CertificateValidity cv = (CertificateValidity) cinfo.get(X509CertInfo.VALIDITY);
        // 有效期为当前日期后延 n 天
        Date d2 = new Date(new Date().getTime() + n * 24 * 60 * 60 * 1000L);
//        System.out.println("new date:" + d2.toString());
        // 创建有效期对象
        cv.set(CertificateValidity.NOT_AFTER, d2);
        cinfo.set(X509CertInfo.VALIDITY, cv); // 设置有效期
        saveCert(alias, keypass, cinfo, sigAlgrithm);
//        System.out.println(getExpiration());
    }

    /**
     * 读取证书过期时间
     * @return
     * @throws Exception
     */
    public Date getExpiration() throws Exception {
        X509CertInfo cinfo = getX509CertInfo();
        CertificateValidity cv = (CertificateValidity) cinfo.get(X509CertInfo.VALIDITY);
        // 创建有效期对象
        return  (Date) cv.get(CertificateValidity.NOT_AFTER);
    }

    /**
     * 存储证书
      * @param alias
     * @param keypass
     * @param cinfo
     * @param algrithm
     * @throws Exception
     */
    private void saveCert(String alias, String keypass,
                          X509CertInfo cinfo, String algrithm) throws Exception {
        // 从密钥库中读取 CA 的私钥
        PrivateKey pKey = (PrivateKey) keyStore.getKey(alias, keypass.toCharArray());
        X509CertImpl cert = new X509CertImpl(cinfo); // 新建证书
        cert.sign(pKey, algrithm); // 使用 CA 私钥对其签名
        // 获取别名对应条目的证书链
        Certificate[] chain = new Certificate[]{cert};
        // 向密钥库中添加条目 , 使用已存在别名将覆盖已存在条目
        keyStore.setKeyEntry(alias, pKey, keypass.toCharArray(), chain);
        // 将 keystore 存储至文件
        FileOutputStream fOut = new FileOutputStream(file);
        keyStore.store(fOut, storePass);
        fOut.close();
    }

    /**
     * 获取签名算法
     * @return
     * @throws Exception
     */
    public String getSigAlgName() throws Exception {
        Certificate c = keyStore.getCertificate(alias); // 读取证书
        // 获取 证书内容（经过编码的字节）　　
        byte[] enc = c.getEncoded();
        // 创建 X509CertImpl 对象
        X509CertImpl cimp2 = new X509CertImpl(enc);
        return cimp2.getSigAlgName();
    }

    public String exportCert() throws Exception {
        sb = new StringBuffer();
        Certificate cert = this.keyStore.getCertificate(alias);
        this.writeObject(new MiscPEMGenerator(cert));
        return sb.toString();
    }
    public String exportPrivateKey() throws Exception {
        sb = new StringBuffer();
        PrivateKey pKey = (PrivateKey) keyStore.getKey(alias,storePass);
        Certificate cert = keyStore.getCertificate(alias);
        KeyPair privateKey = new KeyPair(cert.getPublicKey(), pKey);
        this.writeObject(new MiscPEMGenerator(privateKey));
        return sb.toString();
    }

    public void createPem(final String filePath) throws Exception{
        Certificate certP12 = this.keyStore.getCertificate(alias);
        File file = new File(filePath);
        FileWriter fileWriter=null;
        PEMWriter pemWriter =null;
        try {
            fileWriter = new FileWriter(file);

            pemWriter = new PEMWriter(fileWriter);
            pemWriter.writeObject(certP12);
            pemWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(pemWriter!=null) {
                pemWriter.close();
            }
            if(fileWriter!=null) {
                fileWriter.close();
            }
        }
    }

    public void createPrivateKey(String filePath) throws Exception{
        PEMWriter writer = null;
        try {
            Key key = this.keyStore.getKey(alias, storePass);
            if (key instanceof PrivateKey) {
                Certificate cert = this.keyStore.getCertificate(alias);
                KeyPair privateKey = new KeyPair(cert.getPublicKey(), (PrivateKey) key);

                FileWriter fw = new FileWriter(filePath);
                writer = new PEMWriter(fw);
                writer.writeObject(privateKey);
            }
        } catch (UnrecoverableKeyException e) {
            log.error("UnrecoverableKeyException:",e);
        } catch (NoSuchAlgorithmException e) {
            log.error("NoSuchAlgorithmException:",e);
        } catch (KeyStoreException e) {
            log.error("KeyStoreException:",e);
        }finally {
            if(writer!=null) {
                writer.close();
            }
        }
    }

    public void writeObject(PemObjectGenerator var1) throws IOException {
        PemObject var2 = var1.generate();
        this.writePreEncapsulationBoundary(var2.getType());
        if(!var2.getHeaders().isEmpty()) {
            Iterator var3 = var2.getHeaders().iterator();

            while(var3.hasNext()) {
                PemHeader var4 = (PemHeader)var3.next();
                this.write(var4.getName());
                this.write(": ");
                this.write(var4.getValue());
                this.newLine();
            }

            this.newLine();
        }

        this.writeEncoded(var2.getContent());
        this.writePostEncapsulationBoundary(var2.getType());
    }

    private void writeEncoded(byte[] var1) throws IOException {
        char[] buf = new char[64];
        var1 = Base64.encode(var1);

        for(int var2 = 0; var2 < var1.length; var2 += buf.length) {
            int var3;
            for(var3 = 0; var3 != buf.length && var2 + var3 < var1.length; ++var3) {
                buf[var3] = (char)var1[var2 + var3];
            }

            this.write(buf, 0, var3);
            this.newLine();
        }

    }
    private void writePreEncapsulationBoundary(String var1) throws IOException {
        this.write("-----BEGIN " + var1 + "-----");
        this.newLine();
    }

    private void writePostEncapsulationBoundary(String var1) throws IOException {
        this.write("-----END " + var1 + "-----");
        this.newLine();
    }

    private void write(String temp){
        sb.append(temp);
    }
    public void write(char cbuf[], int off, int len) throws IOException {
        for(int i=off;i<len;i++) {
            sb.append(cbuf[i]);
        }
    }
    private void newLine(){
        sb.append(StringPool.RETURN_NEW_LINE);
    }


    //    public static byte[] pemToPKCS12(final String keyFile, final String cerFile, final String password) throws Exception {
//        // Get the private key
//        FileReader reader = new FileReader(keyFile);
//
//        PEMReader pem = new PEMReader(reader, new PasswordFinder() {
//            @Override public char[] getPassword() {
//                return password.toCharArray();
//            }
//        });
//
//        PrivateKey key = ((KeyPair)pem.readObject()).getPrivate();
//
//        pem.close();
//        reader.close();
//
//        // Get the certificate
//        reader = new FileReader(cerFile);
//        pem = new PEMReader(reader);
//
//        X509Certificate cert = (X509Certificate)pem.readObject();
//
//        pem.close();
//        reader.close();
//
//        // Put them into a PKCS12 keystore and write it to a byte[]
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        KeyStore ks = KeyStore.getInstance("PKCS12");
//        ks.load(null);
//        ks.setKeyEntry("alias", (Key)key, password.toCharArray(), new java.security.cert.Certificate[]{cert});
//        ks.store(bos, password.toCharArray());
//        bos.close();
//        return bos.toByteArray();
//    }


    public static void main(String[] args) {
        try{
            Pkcs12Manager manager = new Pkcs12Manager(new File("/Users/xuetao/code/gitcode/wsk2/wsk-server/src/main/webapp/uploadFile/templates/iosCertificate.p12"),"123456");

//            manager.createPem("/Users/xuetao/code/gitcode/wsk2/wsk-server/src/main/webapp/uploadFile/templates/iosCert.pem");

//            String cert = manager.exportCert();
//            System.out.println(cert);
//            String key = manager.exportPrivateKey();
//            System.out.println(key);

//            String day = manager.getExpiration().toString();
//            System.out.println(day);

            System.out.println(manager.getUid());
        }catch (IOException ie){
            System.err.println(ie.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
