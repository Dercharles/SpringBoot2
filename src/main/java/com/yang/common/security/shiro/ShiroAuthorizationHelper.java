/**   
 * @Title: ShiroAuthorizationHelper.java 
 * @Package com.visionet.sloth2.kefu.common.security.shiro 
 * @Description:清除当前用户登陆认证
 * @author liusy@visionet.com.cn   
 * @date Apr 13, 2015 3:28:55 PM 
 * @version V1.0   
 */
package com.yang.common.security.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/** 
 * @ClassName: ShiroAuthorizationHelper 
 * @Description: 清除当前用户登陆认证
 * @author liusy@visionet.com.cn
 * @date Apr 13, 2015 3:28:55 PM 
 *  
 */
public class ShiroAuthorizationHelper {
	private static final Logger log = LoggerFactory.getLogger(ShiroAuthorizationHelper.class);

	 private static CacheManager cacheManager;  

	/** 
	 * @Title: clearAuthorizationInfo 
	 * @Description: 清除授权信息
	 * @param username    设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void clearAuthorizationInfo(String username) {
		if (log.isDebugEnabled()) {
			log.debug("clear the " + username + " authorizationInfo");
		}
		Cache<Object, Object> cache = cacheManager.getCache("authorizationCache");
		cache.remove(username);
	}
	
	/** 
	 * @Title: clearAuthorizationInfo 
	 * @Description: 清除授权信息
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void clearAuthorizationInfo(){  
        if(SecurityUtils.getSubject().isAuthenticated()){  
            clearAuthorizationInfo(ShiroSecurityHelper.getCurrentUsername());  
        }  
    }  

	/** 
	 * @Title: clearAuthenticationInfo 
	 * @Description:清除session信息
	 * @param JSESSIONID    设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void clearAuthenticationInfo(Serializable JSESSIONID) {
		if (log.isDebugEnabled()) {
			log.debug("clear the session " + JSESSIONID);
		}
		// shiro-activeSessionCache
		// 为shiro自义cache名，该名在org.apache.shiro.session.mgt.eis.CachingSessionDAO抽象类中定义
		// 如果要改变此名，可以将名称注入到sessionDao中，例如注入到CachingSessionDAO的子类EnterpriseCacheSessionDAO类中
		Cache<Object, Object> cache = cacheManager.getCache("shiro-activeSessionCache");
		cache.remove(JSESSIONID);
	} 

	public static CacheManager getCacheManager() {
		return cacheManager;
	}

	public static void setCacheManager(CacheManager cacheManager) {
		ShiroAuthorizationHelper.cacheManager = cacheManager;
	} 
}
