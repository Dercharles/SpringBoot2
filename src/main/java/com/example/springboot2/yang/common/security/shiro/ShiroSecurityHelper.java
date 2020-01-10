/**   
 * @Title: ShiroSecurityHelper.java 
 * @Package com.visionet.sloth2.kefu.common.schedule 
 * @Description: 登陆帮助类
 * @author liusy@visionet.com.cn   
 * @date Apr 13, 2015 3:02:37 PM 
 * @version V1.0   
 */
package com.example.springboot2.yang.common.security.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Date;

/** 
 * @ClassName: ShiroSecurityHelper 
 * @Description:登陆帮助类
 * @author liusy@visionet.com.cn
 * @date Apr 13, 2015 3:02:37 PM 
 *  
 */
public class ShiroSecurityHelper {
	private static final Logger log = LoggerFactory.getLogger(ShiroSecurityHelper.class);

	private static SessionDAO sessionDAO;

	/** 
	 * @Title: getCurrentUsername 
	 * @Description: 获取当前用户名
	 * @return    设定文件 
	 * @return String    返回类型 
	 * @throws 
	 */
	public static String getCurrentUsername() {
		Subject subject = getSubject();
		PrincipalCollection collection = subject.getPrincipals();
		if (null != collection && !collection.isEmpty()) {
			return (String) collection.iterator().next();
		}
		return null;
	}

	/** 
	 * @Title: getSession 
	 * @Description:获取会话
	 * @return    设定文件 
	 * @return Session    返回类型 
	 * @throws 
	 */
	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	/** 
	 * @Title: getSessionId 
	 * @Description: 获取会话ID
	 * @return    设定文件 
	 * @return String    返回类型 
	 * @throws 
	 */
	public static String getSessionId() {
		Session session = getSession();
		if (null == session) {
			return null;
		}
		return getSession().getId().toString();
	}
	
	/** 
	 * @Title: getSessionByUsername 
	 * @Description:根据用户名获取会话
	 * @param username
	 * @return    设定文件 
	 * @return Session    返回类型 
	 * @throws 
	 */
	public static Session getSessionByUsername(String username){
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		for(Session session : sessions){
			if(null != session && StringUtils.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)), username)){
				return session;
			}
		}
		return null;
	}
	
	/** 
	 * @Title: kickOutUser 
	 * @Description: 踢出用户
	 * @param username    设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void kickOutUser(String username){
		Session session = getSessionByUsername(username);
		if(null != session && !StringUtils.equals(String.valueOf(session.getId()), ShiroSecurityHelper.getSessionId())){
			try {
				//清除认证
				ShiroAuthorizationHelper.clearAuthenticationInfo(session.getId());
//				log.info("success kick out user {} ------ {}", username,new Date());
			} catch (Exception e) {
				log.error("error kick out user {} ------ {}----- {}", username,new Date(),e.fillInStackTrace());
			}
		}
	}

	public static void initStaticField(SessionDAO sessionDAO) {
		ShiroSecurityHelper.sessionDAO = sessionDAO;
	}

	/** 
	 * @Title: hasAuthenticated 
	 * @Description:是否已认证
	 * @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws 
	 */
	public static boolean hasAuthenticated() {
		return getSubject().isAuthenticated();
	}

	/** 
	 * @Title: getSubject 
	 * @Description:获取当前登陆用户
	 * @return    设定文件 
	 * @return Subject    返回类型 
	 * @throws 
	 */
	private static Subject getSubject() {
		return SecurityUtils.getSubject();
	}
}
