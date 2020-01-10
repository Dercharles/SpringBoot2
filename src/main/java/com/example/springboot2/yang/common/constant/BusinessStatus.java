package com.example.springboot2.yang.common.constant;

/**
 * 状态码
 */
public class BusinessStatus {
	// success
	public static final String OK = "10000";
	// error
	public static final String ERROR = "10001";
	// 长度限制
	public static final String LENGTH_LIMIT = "10002";
	// 数据为空
	public static final String DATA_EMPTY = "10003";
	// 违规操作
	public static final String ILLEGAL = "10004";
	// 禁止访问
	public static final String ACCESSDENIED = "10005";
	// 资源不存在
	public static final String NOTFIND = "10006";
	// 非空限制
	public static final String REQUIRE = "10007";
	//名称重复
	public static final String NAMEREPEAT = "10008";
	//操作提醒
	public static final String WARNING = "10009";
	
	//Admin禁止访问
	public static final String ADMINDENY = "10010";
	//普通用户禁止访问
	public static final String USERDENY = "10011";
	
	//公司已注销
	public static final String ORG_LOCK = "10012";

    //外部接口错误
    public static final String INTERFACE_ERROR = "10013";
    //版本冲突
    public static final String VERSION_CONFLICT = "10014";

    public static final boolean RESULT_TRUE = true;
    public static final boolean RESULT_FALSE = false;

	//秘钥授权失败
	public static final String AUTHORIZE_FAILED = "10015";

    public static final String SESSION_INVALID = "11111";

    public static final String SUCCESS = "success";
}
