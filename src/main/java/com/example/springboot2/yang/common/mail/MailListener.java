package com.example.springboot2.yang.common.mail;

import javax.mail.Message;
import javax.mail.Store;

public class MailListener {
	public void each(Message msg,MailBean mailBean){}
	
	public boolean connect(Store store){return true;}
}
