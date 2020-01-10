package com.example.springboot2.yang.common.modules;

import com.example.springboot2.yang.common.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service("messageSourceHelper")
public class MessageSourceHelper {
	private static Logger log = LoggerFactory.getLogger(MessageSourceHelper.class);
	
	//@Autowired
	private ReloadableResourceBundleMessageSource messageSource;

	public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
//		if(locale == null){
//            locale = new Locale(BaseController.getLocale());
//		}
//		System.out.println("---locale4="+locale.getLanguage());
		String msg = messageSource.getMessage(code, args, defaultMessage,locale);
		
		return msg != null ? msg.trim() : msg;
	}
	public String getMessage(String code) {
		String msg = this.getMessage(code,null,"",null);
		return msg != null ? msg.trim() : msg;
	}
	
	public static String GetMessages(String code) {
		String msg = ((MessageSourceHelper) SpringContextUtil.getBean("messageSourceHelper")).getMessage(code);
		return msg != null ? msg.trim() : msg;
	}

    public static String GetMessages(String code,Object[] args) {
        String msg = ((MessageSourceHelper)SpringContextUtil.getBean("messageSourceHelper")).getMessage(code, args, "", null);
		return msg != null ? msg.trim() : msg;
    }
	

	public void setMessageSource(ReloadableResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}
}
