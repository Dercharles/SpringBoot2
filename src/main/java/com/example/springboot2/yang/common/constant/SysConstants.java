package com.example.springboot2.yang.common.constant;

import com.google.common.collect.Lists;
import com.example.springboot2.yang.common.modules.props.PropsKeys;
import com.example.springboot2.yang.common.modules.props.PropsUtil;
import com.example.springboot2.yang.common.modules.string.GetterUtil;

import java.util.List;

public interface SysConstants {

	public static final String PROJECT_NAME = "wsk2";
	public static final String WEB_PROJECT_NAME = GetterUtil.getString(PropsUtil.getProperty(PropsKeys.WEB_PROJECT_NAME), "");
	public static final String WEB_H5_NAME = "letsdesk-webapp";

	/*---------------- Login ---------------------*/
	public static final String CLIENT_FLAG = "client_flag";
	public static final String CLIENT_WEB = "web";
	public static final String CLIENT_IOS = "ios";
	public static final String CLIENT_ANDROID = "android";
	public static final String CLIENT_WEIXIN = "weixin";

	public static final String SESSION_FORCE_LOGOUT_KEY = "session.force.logout";
	
	/*---------------- Common ---------------------*/
	public static final String SYSTEM_NAME = "系统消息";
	public static final String ROBOT_TO_KEFU_KEY = "ZRG";
	public static final String ROBOT_TO_KEFU_VALUE = "“转人工按钮”";


	public static final int DELETE_FLAG_YES=1;
	public static final int DELETE_FLAG_NO=0;
	
	public static final String TMP_DIR = "java.io.tmpdir";
	
	public static final String SORT_TYPE_AUTO = "auto";
	public static final String JSP_SEARCH_FILTER = "search_";
	
	public static final String PRIVACY_FILTER = "confidentiality";
	
	
	/*---------------- Console ---------------------*/
	public static final String CONSOLE_FLAG="consoleFlag";
	
	/*---------------- User ---------------------*/
	public static final String CURRENT_USER = "user";
	
	public static final int USER_ACTIVITY_ENABLED = 0;
	public static final int USER_ACTIVITY_DISABLED = 1;
	public static final int USER_ACTIVITY_TODO_PAY = 2;		//已过期待付款

	/*---------------- Role ---------------------*/
	public static final String PERMISSIONS = "view,edit";
	public static final String ADMIN_ROLE_TYPE = "A";
	public static final String SUBADMIN_ROLE_TYPE = "C";
	public static final String COMMON_ROLE_TYPE = "B";
	public static final String MOBILE_ROLE_TYPE = "M";
	public static final String DEALER_ROLE_TYPE = "D";

	public static final int PERSION_TYPE_WORKBENCH = 1;
	public static final int PERSION_TYPE_CONSOLE = 2;
	public static final int PERSION_TYPE_PAY = 3;

    //超级管理员
	public static final String ADMINISTRATOR = "admin";
	//财务管理员
	public static final String FINANCE_ADMIN = "financeadmin";
	//接口测试管理员
	public static final String TEST_ADMIN = "testadmin";
    //公司管理员
	public static final String SUBADMIN = "subadmin";
	//app管理员
	public static final String APPADMIN = "appadmin";
    //经理
    public static final String MANAGER = "manager";
    //组长
//	public static final String TEAM_LEADER = "teamLeader";
    //客服
    public static final String CUSTOMER_SERVICE = "customService";
    //手机客服
	public static final String MOBILE_SERVICE = "mobileService";
    //工程师
    public static final String ENGINEER = "engineer";
	//销售
	public static final String SALES = "sales";
	//经销商
	public static final String DEALER = "dealer";
	//密号管理员
	public static final String SMART_NUMBER = "smartNumber";
	//参会人员
	public static final String CONFEREE = "conferee";

	public static final List<String> ServiceRoleList = Lists.newArrayList(MANAGER,CUSTOMER_SERVICE,MOBILE_SERVICE);
	
	
	/*---------------- Organization ---------------------*/
	public static final int ORG_ACTIVITY_ENABLED = 0;
	public static final int ORG_ACTIVITY_DISABLED = 1;

	public static final String ORG_DOMAIN_DEALER = "dealer.";

	public static final int ORG_VERSION_ADMIN = 0;		//管理员、经销商等后台管理
//	public static final int ORG_VERSION_TRIAL = 1;		//试用版
	public static final int ORG_VERSION_STANDARD = 2;	//基础班
	public static final int ORG_VERSION_PRO = 3;		//标准版
	public static final int ORG_VERSION_DIY = 4;		//定制版
	/*---------------- Resource ---------------------*/
	public static final int RESOURCE_TYPE_TOP=0;
	public static final int RESOURCE_TYPE_WORKBENCH=1;
	public static final int RESOURCE_TYPE_CONSOLE=2;
	public static final int RESOURCE_TYPE_PAY_MODULE=3;

	/*-------------------管理员id--------------------*/
	public static final Long ADMIN_ID = 1l;
	
	/*---------------- 短信 ---------------------*/
	public static final Integer SMS_UNSENT = 0;
	public static final Integer SMS_SENT = 1;
	public static final Integer SMS_DONOT_SEND = -1;
	
}
