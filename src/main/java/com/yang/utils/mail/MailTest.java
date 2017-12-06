package com.yang.utils.mail;

/**
 * 测试
 */
public class MailTest {
    public static void main(String[] args) throws Exception {
        MailSender mailSender = MailSender.getInstance();
        MailInfo mailInfo = mailSender.getMailInfo();
        mailSender.sendHtmlMail(mailInfo, 3);
    }
}
