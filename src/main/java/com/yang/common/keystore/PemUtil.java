package com.yang.common.keystore;

import org.bouncycastle.openssl.PEMWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class PemUtil {

    /**
     * Export Private Key to File
     *
     * @throws Exception
     */
    public static void exportPrivateKey() throws Exception {
        Security.addProvider(new
                org.bouncycastle.jce.provider.BouncyCastleProvider());

        KeyStore keystore = KeyStore.getInstance("PKCS12", "BC");

        keystore.load(new FileInputStream("/Users/xuetao/code/gitcode/wsk2/wsk-server/src/main/webapp/uploadFile/templates/iosCertificate.p12"),
                "123456".toCharArray());
        KeyPair keyPair = PemUtil.getPrivateKey(keystore, "iosCertificate",
                "123456".toCharArray());
        PrivateKey privateKey = keyPair.getPrivate();

        /**
         * THIS DOES NOT WORK, GENERATES INCORRECT SEQUENCE
         *
         * String encoded = new String(Base64.encode(privateKey.getEncoded()));
         *
         * FileWriter fw = new FileWriter("private.key");
         * fw.write("-----BEGIN RSA PRIVATE KEY-----\n"); fw.write(encoded);
         * fw.write("\n"); fw.write("-----END RSA PRIVATE KEY-----");
         * fw.close();
         **/

        FileWriter fw = new FileWriter("/Users/xuetao/code/gitcode/wsk2/wsk-server/src/main/webapp/uploadFile/templates/iosCertificate.pem");
        PEMWriter writer = new PEMWriter(fw);
        writer.writeObject(privateKey);
        writer.close();
    }


    /**
     * Extract the Private Key from the Keystore.
     *
     * @param keystore
     * @param alias
     * @param password
     * @return
     */
    public static KeyPair getPrivateKey(KeyStore keystore, String alias,
                                         char[] password) {
        try {
            Key key = keystore.getKey(alias, password);
            if (key instanceof PrivateKey) {
                java.security.cert.Certificate cert = keystore
                        .getCertificate(alias);
                PublicKey publicKey = cert.getPublicKey();
                return new KeyPair(publicKey, (PrivateKey) key);
            }
        } catch (UnrecoverableKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        } catch (KeyStoreException e) {
        }
        return null;
    }

    /**
     * Get Public Key from Certificate.
     *
     * @return
     * @throws CertificateException
     * @throws FileNotFoundException
     */
    private static PublicKey getPublicKey(String certFilename) throws CertificateException,
            FileNotFoundException {

        InputStream certFileIs = new FileInputStream(certFilename);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate cert = (X509Certificate) cf
                .generateCertificate(certFileIs);

        return cert.getPublicKey();
    }

    public static void main(String[] args) {
        try {
            exportPrivateKey();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
