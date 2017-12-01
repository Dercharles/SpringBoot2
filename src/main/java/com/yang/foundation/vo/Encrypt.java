/**   
 * @Title: Encrypt.java 
 * @Package com.visionet.sloth2.kefu.entity.vo.talk 
 * @Description: TODO:
 * @author liusy@visionet.com.cn   
 * @date Apr 9, 2015 3:07:06 PM 
 * @version V1.0   
 */
package com.yang.foundation.vo;

import java.io.Serializable;

/** 
 * @ClassName: Encrypt 
 * @Description:
 * @author liusy@visionet.com.cn
 * @date Apr 9, 2015 3:07:06 PM 
 *  
 */
public class Encrypt implements Serializable {
	private static final long serialVersionUID = -6431871495642409459L;
	private Long timestamp;
	private String accessToken;
	
	public Encrypt() {
	}
	
	public Encrypt(Long timestamp, String accessToken) {
		this.timestamp = timestamp;
		this.accessToken = accessToken;
	}

	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
