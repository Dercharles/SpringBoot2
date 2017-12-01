package com.yang.common.base.controller;

import com.google.common.collect.Maps;
import com.yang.common.constant.BusinessStatus;
import com.yang.common.constant.MobileKey;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BaseController {
//	public static final String DefaultLocale = GetterUtil.getString(PropsUtil.getProperty(PropsKeys.DEFAULT_LOCALE), "zh");
//
//	protected JsonMapper mapper = new JsonMapper();
//
	public static Map<String,String> GetSuccMap(){
		Map<String,String> map = Maps.newHashMap();
        map.put(MobileKey.CODE, BusinessStatus.OK);
		return map;
	}
//	public static Map<String,Object> GetSuccMap(Long id){
//		Map<String,Object> map = Maps.newHashMap();
//		map.put(MobileKey.CODE, BusinessStatus.OK);
//		map.put("id", id);
//		return map;
//	}
//
//	public static void setLocale(String locale) {
//		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		if(user==null) return;
//		user.locale = locale;
//	}
//
//	public static String getLocale() {
//		String locale=null;
//		try {
//			if (SecurityUtils.getSubject() != null) {
//				ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//				if (user != null) {
//					locale = user.locale;
//				}
//			}
//		}catch (Exception e){
//		}
//		return locale==null?DefaultLocale:locale;
//	}
//
	public static Long getCurrentOrgId() {
//		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		if(user==null) return null;
//        return user.orgId;
		return 1l;
	}
//
//
//
//	/**
//	 * 取出Shiro中的当前用户逻辑Id.
//	 * 当前用户为秘书且代理功能打开时，返回领导id
//	 */
//	public static Long getCurrentUserId() {
//		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		if(user==null) return null;
//		if(isAgency()&&user.secId!=null){
//			return user.secId;
//		}
//		return user.id;
//	}
//
//	/**
//	 * 取出Shiro中的当前用户真实Id.
//	 */
//	public static Long getLoginUserId() {
//		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		if(user==null) return null;
//		return user.id;
//	}
//
//
//	/**
//	 * 取出Shiro中的当前用户显示姓名.
//	 * 当前用户为秘书且代理功能打开时，返回领导id
//	 */
//	public static String getCurrentUserName() {
//		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		if(user==null) return null;
//		if(isAgency()){
//			return user.secName;
//		}
//		return user.aliasName;
//	}
//
//	/**
//	 * 取出Shiro中的当前用户真实姓名.
//	 */
//	public static String getLoginUserName() {
//		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		if(user==null) return null;
//		return user.loginName;
//	}
//
//    public static void setAliasName(String aliasName) {
//        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//        if(user==null) return;
//        user.aliasName = aliasName;
//    }
//
//
//	/**
//	 * 判断当前用户是否有某些角色.
//	 * @param role
//	 * @return
//	 */
//	public static boolean hasRole(String role){
//		return SecurityUtils.getSubject().hasRole(role);
//	}
//
//	/**
//	 * 判断当前用户是否有某些角色.
//	 * @param roles
//	 * @return
//	 */
//	public static boolean hasRole(List<String> roles){
//		boolean[] result = SecurityUtils.getSubject().hasRoles(roles);
//		for(boolean role : result){
//			if(role){
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public static boolean isAdmin(){
//		if(SecurityUtils.getSubject().hasRole(SysConstants.ADMINISTRATOR)){
//			return true;
//		}else if(SecurityUtils.getSubject().hasRole(SysConstants.SUBADMIN)){
//			return true;
//		}
//		return false;
//	}
//
//    public static boolean isAppRole(){
//        if(SecurityUtils.getSubject().hasRole(SysConstants.CUSTOMER_SERVICE)){
//            return true;
//        }else if(SecurityUtils.getSubject().hasRole(SysConstants.ENGINEER)){
//            return true;
//        }
//        return false;
//    }
//
//	/**
//	 * 判断当前用户是否有某些权限.
//	 * @param permission
//	 * @return
//	 */
//	public static boolean hasPermission(String permission){
//		return SecurityUtils.getSubject().isPermitted(permission);
//	}
//
//	/**
//	 * 判断当前用户是否为秘书代领导角色
//	 * @return
//	 */
//	public static boolean isAgency(){
////		return hasRole(SysConstants.AGENCY);
//
//        return false;
//	}
//
//	/**
//	 * 判断当前用户或其领导是否关闭秘书代理功能
//	 * @return
//	 */
//	public static boolean isCloseAgency(){
//		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		if(user==null) throw new AuthenticationException();
//		if(user.isLockSec == 1) return true;
//		else return false;
//	}
//
//	/**
//	 * 获取当前用户对应领导/秘书ID
//	 * @return
//	 */
//	public static Long getLeaderOrAssistantId(){
//		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		if(user==null) throw new AuthenticationException();
//		return user.secId;
//	}
//
//	/**
//	 * 如果当前用户是秘书并且在代理领导，则返回秘书ID （自己）， 其他则返回null
//	 * 为了agency_id的设值
//	 * @return
//	 */
////	public static Long getAgencyUserId(){
////		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
////		if(user==null) throw new AuthenticationException();
////		if(isAgency()){
////			return user.id;
////		}else{
////			return null;
////		}
////
////	}
//
//	public static String getCurrentRole(){
//		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		if(user==null) return null;
//		return user.getRoleNames();
//	}
//
//	public static String getUserImgUrl(){
//		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		if(user==null) return null;
//		return user.getUserImgUrl();
//	}
//
//	protected void writer(HttpServletResponse res, String obj) throws Exception {
//		res.setCharacterEncoding("UTF-8");
//		PrintWriter pw=null;
//		try {
//			pw = res.getWriter();
//			pw.print(obj);
//		} catch (Exception e) {
//			throw e;
//		}finally{
//			if(null!=pw){
//				pw.flush();
//				pw.close();
//			}
//		}
//	}
//
//	public static void throwException(String code,String msg) {
//		Map<String,String> result = Maps.newHashMap();
//		result.put("code", code);
//		result.put("msg", msg);
//		throw new RestException(result);
//	}
//
//	public static void throwException(Map<String,String> result) {
//		result.put(BusinessStatus.ERROR, MessageSourceHelper.GetMessages("app.web.BaseController.check.fail"));
//
//		throw new RestException(result);
//	}
//
//    public static void CheckOrgId(Long orgId){
//        if(!AccountService.isSupervisor(getCurrentUserId()) && orgId.intValue()!=getCurrentOrgId().intValue()){
//            throwException(BusinessStatus.ILLEGAL,"organization illegal!");
//        }
//    }
//
//	public static String getClientIp(HttpServletRequest request){
//		String ip = request.getHeader("x-forwarded-for");
////        System.out.println("---ip1="+ip);
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("Proxy-Client-IP");
////            System.out.println("---ip2="+ip);
//		}
//
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("WL-Proxy-Client-IP");
////            System.out.println("---ip3="+ip);
//		}
//
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getRemoteAddr();
////            System.out.println("---ip4="+ip);
//		}
//		if(ip.contains(",")){
//			ip = ip.substring(0,ip.indexOf(","));
//		}
//
//		return ip;
//	}
//	public static String getClientHost(HttpServletRequest request){
//		//visionet.findest.com
//		return request.getHeader("Host");
//	}
//
//	public static String getClientHost(String subdomain){
//		String organization = PropsUtil.getProperty(PropsKeys.ORGANIZATION_DOMAIN);
//		if(organization.startsWith("www.")){
//			organization = organization.replaceFirst("www",subdomain);
//		}else {
//			organization = subdomain+"."+organization;
//		}
//		return organization;
//	}
//
//	protected static <T> Page<T> GetPageByList(PageInfo pageInfo, List<T> volist, Class<T> destinationClass){
//		if(volist == null || pageInfo == null){
//			return null;
//		}
//
//		if(volist.isEmpty()){
//			return new PageImpl<T>(volist, new PageRequest(
//					pageInfo.getCurrentPageNumber(), 0, new Sort(
//							pageInfo.getSortType(), pageInfo.getSortColumn())),
//					0);
//		}else{
//			return new PageImpl<T>(volist, new PageRequest(
//					pageInfo.getCurrentPageNumber(), pageInfo.getPageSize(), new Sort(
//							pageInfo.getSortType(), pageInfo.getSortColumn())),
//					pageInfo.getTotalCount());
//		}
//
//	}
//
//	protected static <T> Page<T> GetPageByList(Page<?> page, List<T> volist, Class<T> destinationClass){
//		return new PageImpl<T>(volist, new PageRequest(page.getNumber(),
//				page.getSize(), page.getSort()), page.getTotalElements());
//	}
}
