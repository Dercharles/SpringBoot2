package com.yang.common.security.password;


import com.yang.common.modules.string.StringPool;

/**
 * 
 * @author visionet
 *
 */
public interface Digester {

	public static final String ENCODING = StringPool.UTF8;

	public static final String DIGEST_ALGORITHM = "SHA";

	public String digest(String text);

	public String digest(String algorithm, String text);

}
