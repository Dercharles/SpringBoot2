package com.yang.common.utils;

import com.google.common.collect.Lists;
import com.yang.common.file.FileUtil;
import com.yang.common.modules.props.PropsKeys;
import com.yang.common.modules.props.PropsUtil;
import com.yang.common.modules.string.StringPool;
import com.yang.common.modules.time.DateUtil;
import com.yang.common.modules.validate.Validator;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UploadUtil {
	public static String DOCUMENT = "document";
	public static String IMAGE = "image";
	public static String VIDEO = "video";
	public static String AUDIO = "audio";
	public static String CERT = "certificate";
	public static String DEFAULT = "default";

	/**
	 * path: /home/visionet/sloth/product_affix/cmcc/uploadFile/o1/YYYYMMDD/stream/7efbd59d9741d34f.doc
	 * relativePath: o1/YYYYMMDD/stream/7efbd59d9741d34f.doc
	 * name: 7efbd59d9741d34f.doc
	 * realName: test_2016.doc
	 * @param sign
	 * @return
	 */
	public static String[] GetCreatePathWithSuffix(String realName,String sign,String namespace) throws Exception{
		String type = realName.substring(realName.lastIndexOf(".") + 1);
		sign = sign == null ? GetSignByType(type) : sign;
		String suffix = "";
		if(!type.isEmpty()){
			suffix = StringPool.PERIOD + type;
		}
		String path = PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_ROOT_PATH);
		
		String name = UUID.randomUUID().toString() + "-" + (int)(Math.random() * 10000) + suffix;

		if(Validator.isNull(namespace)){
			namespace="www";
		}else if(namespace.contains(StringPool.PERIOD)){
			namespace = namespace.substring(0, namespace.indexOf(StringPool.PERIOD));
		}
		String dateStr = namespace+StringPool.FORWARD_SLASH + DateUtil.convertToString(new Date(), DateUtil.YMD1);
		
		String relativePath = dateStr + StringPool.FORWARD_SLASH + (sign == null ? DEFAULT : sign) + StringPool.FORWARD_SLASH + name;
		
		path = path + StringPool.FORWARD_SLASH + relativePath;
		
		FileUtil.mkdirs((new File(path)).getParent());
		
		return new String[]{path,relativePath,name,realName};
	}
	

	public static String GetSignByType(String type){
		if(Validator.isNull(type)){
			return DEFAULT;
		}
		if (GetTypeList(PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_TYPE_DOCUMENT)).contains(type.toLowerCase())) {
			return DOCUMENT;
		} else if (GetTypeList(PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_TYPE_IMG)).contains(type.toLowerCase())) {
			return IMAGE;
		} else if (GetTypeList(PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_TYPE_AUDIO)).contains(type.toLowerCase())) {
			return AUDIO;
		} else if (GetTypeList(PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_TYPE_VIDEO)).contains(type.toLowerCase())) {
			return VIDEO;
		} else if (GetTypeList(PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_TYPE_CERT)).contains(type.toLowerCase())) {
			return CERT;
		}else{
			return DEFAULT;
		}		
	}

	public static boolean IsImage(String type){
		if (GetTypeList(PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_TYPE_IMG)).contains(type.toLowerCase())) {
			return true;
		}else {
			return false;
		}
	}

	public static List<String> GetTypeList(String types){
		return Lists.newArrayList(types.split(StringPool.COMMA));
	}

	public static String GetDownloadPath(Long orgId){
		return null;
	}

	public static String GetAPKDownloadPath(Long orgId){
		return GetDownloadPath(orgId) + PropsUtil.getProperty(PropsKeys.MOBILE_CLIENT_DOWNLOAD_ANDRIOD);
	}
	
	public static String GetIOSDownloadPath(){
		return PropsUtil.getProperty(PropsKeys.SMS_DOWNLOAD_MOBILE_CLIENT_IOS)
				+ PropsUtil.getProperty(PropsKeys.MOBILE_CLIENT_DOWNLOAD_IOS_PLIST);
	}

    public static String GetQrcodeMaxPath(Long orgId){
        return  null;
    }

    public static String GetAndroidSdkDownloadPath(Long orgId){
		return GetDownloadPath(orgId) + PropsUtil.getProperty(PropsKeys.MOBILE_CLIENT_DOWNLOAD_ANDRIOD_SDK);
	}

	public static String GetIosSdkDownloadPath(Long orgId){
		return GetDownloadPath(orgId) + PropsUtil.getProperty(PropsKeys.MOBILE_CLIENT_DOWNLOAD_IOS_SDK);
	}

	public static String GetFullUri(String url,Long orgId){
		if(Validator.isNotNull(url) && url.startsWith(PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_DOWNLOAD_PATH))){
			url = null;
		}
		return url;
	}

}
