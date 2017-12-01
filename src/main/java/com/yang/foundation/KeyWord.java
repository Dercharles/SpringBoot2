package com.yang.foundation;

public interface KeyWord {
	
	
	//删除状态
	public static final int DEL_STATUS = 1;
	
	//非删除状态
	public static final int UN_DEL_STATUS = 0;

    public static final String STREAM_SEND_ALL = "all";

    public static final String YES = "Y";
    public static final String NO = "N";

    public static final int Y = 1;
    public static final int N = 0;

    //性别（男）
	public static final int GENDER_MALE = 1;
	//性别(女)
	public static final int GENDER_FAMALE = 0;
	
	//男头像id
	public static final Long GENDER_MALE_IMAGE_ID = 2l;
	//女头像 id
	public static final Long GENDER_FEMALE_IMAGE_ID = 1l;
	

	//接收消息
	public static final Short RECEIVE_MESSAGE = 1; 
	//不接收消息
	public static final Short NOT_RECEIVE_MESSAGE = 0;

    public static final String NULL = "NULL";


}
