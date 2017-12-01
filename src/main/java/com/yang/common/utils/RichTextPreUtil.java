package com.yang.common.utils;

import com.yang.common.modules.validate.Validator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class  RichTextPreUtil {
	private static Logger log = LoggerFactory.getLogger(RichTextPreUtil.class);

	public static String preImgTag(String contentHtml){
		Document doc = Jsoup.parseBodyFragment(contentHtml);
		Elements elements = doc.body().getElementsByTag("img");
		if(elements.size() > 0){
			for (Element ele : elements) {
				ele.attr("style","max-width:100%;padding:0px;");
			}
			return doc.body().html();
		}
		
		return null;
	}
	public static String transferText(String html){
		try {
			if(Validator.isNull(html)){
				return "";
			}
			Document doc = Jsoup.parseBodyFragment(html);
			return doc.text();
		}catch (Exception e){
			log.error("transferText error!",e);
			return html;
		}
	}
}
