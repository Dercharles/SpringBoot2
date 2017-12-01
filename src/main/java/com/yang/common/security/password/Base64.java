package com.yang.common.security.password;


import com.yang.common.file.FileUtil;
import com.yang.common.modules.props.PropsKeys;
import com.yang.common.modules.props.PropsUtil;
import com.yang.common.modules.string.CharPool;
import com.yang.common.modules.string.StringPool;
import com.yang.common.modules.time.DateUtil;
import com.yang.common.modules.validate.Validator;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author visionet
 */
public class Base64 {

	protected static char getChar(int sixbit) {
		if (sixbit >= 0 && sixbit <= 25) {
			return (char)(65 + sixbit);
		}

		if (sixbit >= 26 && sixbit <= 51) {
			return (char)(97 + (sixbit - 26));
		}

		if (sixbit >= 52 && sixbit <= 61) {
			return (char)(48 + (sixbit - 52));
		}

		if (sixbit == 62) {
			return CharPool.PLUS;
		}

		return sixbit != 63 ? CharPool.QUESTION : CharPool.SLASH;
	}

	protected static int getValue(char c) {
		if ((c >= CharPool.UPPER_CASE_A) && (c <= CharPool.UPPER_CASE_Z)) {
			return c - 65;
		}

		if ((c >= CharPool.LOWER_CASE_A) && (c <= CharPool.LOWER_CASE_Z)) {
			return (c - 97) + 26;
		}

		if (c >= CharPool.NUMBER_0 && c <= CharPool.NUMBER_9) {
			return (c - 48) + 52;
		}

		if (c == CharPool.PLUS) {
			return 62;
		}

		if (c == CharPool.SLASH) {
			return 63;
		}

		return c != CharPool.EQUAL ? -1 : 0;
	}

	public static String encode(byte raw[]) {
		return encode(raw, 0, raw.length);
	}

	public static String encode(byte raw[], int offset, int length) {
		int lastIndex = Math.min(raw.length, offset + length);

		StringBuilder sb = new StringBuilder(
			((lastIndex - offset) / 3 + 1) * 4);

		for (int i = offset; i < lastIndex; i += 3) {
			sb.append(encodeBlock(raw, i, lastIndex));
		}

		return sb.toString();
	}

	protected static char[] encodeBlock(byte raw[], int offset, int lastIndex) {
		int block = 0;
		int slack = lastIndex - offset - 1;
		int end = slack < 2 ? slack : 2;

		for (int i = 0; i <= end; i++) {
			byte b = raw[offset + i];

			int neuter = b >= 0 ? ((int) (b)) : b + 256;
			block += neuter << 8 * (2 - i);
		}

		char base64[] = new char[4];

		for (int i = 0; i < 4; i++) {
			int sixbit = block >>> 6 * (3 - i) & 0x3f;
			base64[i] = getChar(sixbit);
		}

		if (slack < 1) {
			base64[2] = CharPool.EQUAL;
		}

		if (slack < 2) {
			base64[3] = CharPool.EQUAL;
		}

		return base64;
	}

	public static byte[] decode(String base64) {
		if (Validator.isNull(base64)) {
			return new byte[0];
		}

		int pad = 0;

		for (int i = base64.length() - 1; base64.charAt(i) == CharPool.EQUAL;
				i--) {

			pad++;
		}

		int length = (base64.length() * 6) / 8 - pad;
		byte raw[] = new byte[length];
		int rawindex = 0;

		for (int i = 0; i < base64.length(); i += 4) {
			int block = (getValue(base64.charAt(i)) << 18) +
						(getValue(base64.charAt(i + 1)) << 12) +
						(getValue(base64.charAt(i + 2)) << 6) +
						getValue(base64.charAt(i + 3));

			for (int j = 0; j < 3 && rawindex + j < raw.length; j++) {
				raw[rawindex + j] = (byte)(block >> 8 * (2 - j) & 0xff);
			}

			rawindex += 3;
		}

		return raw;
	}



	//base64字符串转化成图片
	public static boolean GenerateImage(String imgStr,String imgFilePath) {   //对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null || imgStr.isEmpty()) { //图像数据为空
			return false;
		}
		if (imgFilePath == null || imgFilePath.isEmpty()) {
			return false;
		}
		if(imgStr.indexOf(StringPool.COMMA)>0){
			imgStr = imgStr.substring(imgStr.indexOf(StringPool.COMMA)+1);
		}
		BASE64Decoder decoder = new BASE64Decoder();
		OutputStream out=null;
		try {
			//Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {//调整异常数据
					b[i] += 256;
				}
			}
			out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if (out != null) out.close();
			}catch (Exception e1){
			}
		}
	}
	public static String GenerateImage(String imgStr){
		if (imgStr == null || imgStr.isEmpty()) { //图像数据为空
			return null;
		}
		String path = PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_ROOT_PATH)
				+ PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_DOWNLOAD_PATH);

		String name = UUID.randomUUID().toString() + "-" + (int)(Math.random() * 10000) + ".jpg";
		String dateStr = DateUtil.convertToString(new Date(), DateUtil.YMD1);

		String relativePath = dateStr + StringPool.FORWARD_SLASH + "image" + StringPool.FORWARD_SLASH + name;
		path += relativePath;

		FileUtil.mkdirs((new File(path)).getParent());

		if(GenerateImage(imgStr,path)) {
			return PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_DOWNLOAD_PATH) + relativePath;
		}else{
			return null;
		}
	}

}