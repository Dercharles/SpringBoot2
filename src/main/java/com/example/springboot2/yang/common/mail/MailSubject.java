package com.example.springboot2.yang.common.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;

/**
 * Created by yangp on 2017/8/29.
 */
public class MailSubject extends MimeMessage {
    protected static Logger log = LoggerFactory.getLogger(MailSubject.class);

    public static String charset_gb2312 = "?gb2312?";

    public MailSubject(MimeMessage message) throws MessagingException {
        super(message);
    }

    @Override
    public String getSubject() throws MessagingException {
        String rawvalue = getHeader("Subject", null);
        if (rawvalue == null) {
            return null;
        }
        if (rawvalue.contains(charset_gb2312)) {
            String s2 = rawvalue.replace("?gb2312?", "?gbk?");
            try {
                return MimeUtility.decodeText(MimeUtility.unfold(s2));
            } catch (UnsupportedEncodingException ex) {
                log.info("MailSubject:"+ex.getMessage());
            }
            return rawvalue;
        } else {
            return super.getSubject();
        }
    }
}
