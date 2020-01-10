package com.example.springboot2.yang.common.security.password;


import com.example.springboot2.yang.common.modules.string.StringPool;

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
