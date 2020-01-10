package com.example.springboot2.yang.common.mail;

import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.internet.MimeBodyPart;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by yangp on 2017/8/29.
 */
public class MailBodyPart extends MimeBodyPart {
    private Part bodyPart;

    public MailBodyPart(Part bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Override
    public String getContent() throws IOException, MessagingException {
        String content = (String) bodyPart.getContent();
        String[] s = bodyPart.getHeader("Content-Type");
        if (s == null){
            return content;
        }
        if (s.length > 0 && s[0].contains("gb2312")) {
            InputStream in = bodyPart.getInputStream();
            StringBuffer sb = new StringBuffer();
            String value = null;
            try {
                InputStreamReader isr = new InputStreamReader(in, "gbk");
                BufferedReader br = new BufferedReader(isr);
                while ((value = br.readLine()) != null) {
                    //value += '\n';
                    sb.append(value);
                }
                isr.close();
                content = sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
                in.close();
            }
        }
        return content;
    }

}
