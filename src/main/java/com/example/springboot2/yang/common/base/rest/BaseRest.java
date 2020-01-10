package com.example.springboot2.yang.common.base.rest;

import com.google.common.collect.Maps;
import com.example.springboot2.yang.common.constant.BusinessStatus;
import com.example.springboot2.yang.common.constant.MobileKey;
import com.example.springboot2.yang.common.modules.mapper.JsonMapper;
import com.example.springboot2.yang.common.modules.props.PropsKeys;
import com.example.springboot2.yang.common.modules.props.PropsUtil;
import com.example.springboot2.yang.common.modules.time.DateUtil;
import com.example.springboot2.yang.common.modules.validate.Validator;
import com.example.springboot2.yang.common.modules.web.MediaTypes;
import com.example.springboot2.yang.common.security.password.ShaUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.nio.charset.Charset;
import java.util.*;

@Component
public abstract class BaseRest {
    private static Log log = LogFactory.getLog(BaseRest.class);

	protected static JsonMapper mapper = JsonMapper.nonDefaultMapper();
	private final static String Authorization = "\"namespace\":\"%s\", \"passwordDigest\":\"%s\", \"nonce\":\"%s\", \"created\":\"%s\" ";
	public static final int PAGE_SIZE = 10;
	
	//这里是集成环境的路径，不能修改它，如果要修改，请在initUlr设置本机的路径
	protected static String SEARCHER_URL = PropsUtil.getProperty(PropsKeys.SEARCHER_SOLR_URL);
	private RestTemplate jdkTemplate;
	protected RestTemplate httpClientRestTemplate;
	private HttpComponentsClientHttpRequestFactory httpClientRequestFactory;
	// 设置处理HttpBasic Header的Interceptor
	protected ClientHttpRequestInterceptor interceptor = null;

	
	protected RestTemplate getRestTemplate(){
		return httpClientRestTemplate;
	}

	
	/**
	 * 这个方法用来设置登录用户信息
	 */
	public abstract void initUser();
	
	protected void setUser(ClientHttpRequestInterceptor interceptor){
		this.interceptor = interceptor;
	}
	
	@PostConstruct
	public  void initResource(){
		
		// 默认使用JDK Connection
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new FormHttpMessageConverter());
//        messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        jdkTemplate = new RestTemplate(messageConverters);
		// (optional)设置20秒超时
		((SimpleClientHttpRequestFactory) jdkTemplate.getRequestFactory()).setConnectTimeout(20000);

		// 设置使用HttpClient4.0
		httpClientRestTemplate = new RestTemplate(messageConverters);
		httpClientRequestFactory = new HttpComponentsClientHttpRequestFactory();
		// (optional)设置20秒超时
		httpClientRequestFactory.setConnectTimeout(20000);

		httpClientRestTemplate.setRequestFactory(httpClientRequestFactory);
//		initUser();
//		if(interceptor==null){
//			throw new RuntimeException("not initial User");
//		}else{
//			httpClientRestTemplate.setInterceptors(Lists.newArrayList(interceptor));
//		}
		
	}
	
	@PreDestroy
	public void close(){
		try {
			// 退出时关闭HttpClient4连接池中的连接
			httpClientRequestFactory.destroy();
		} catch (Exception e) {
			log.error(e.toString(),e);
		}
	}


	/**
	 * 请求消息头生成
	 * @param orgId 公司ID
	 * @return
	 */
	protected static String GenerateAuthorization(Long orgId){
        /*
         请求消息头说明:
          namespace:公司域名
          PasswordDigest:根据公式 PasswordDigest = Base64 (SHA256 (Nonce + Created + AppSecret))生成。
          Nonce:发送请求时生成的一个随机字符串，商户系统产生。 例如:66C92B11FF8A425FB8D4CCFE0ED9ED1F。
          Created:请求时间。标准 UTC 时间(注:UTC 时间比北京时间 晚 8 个小时)，格式为 YYYY-MM-DD'T'hh:mm:ss'Z'。例如:2014-01-07T01:58:21Z。10分钟后超时
          例如："namespace":"wsk1.findest.com","passwordDigest":"cGFd7kfftnHW8npwz4QD38aSYv3HZtQYYkIe9taZcR4=","nonce":"284e40be-afc3-4df1-b77c-abd77a5b2c24","created":"2017-06-20T06:25:48Z", userId:2
        */
		if(Validator.isNull(orgId)){
			throw new RestException("orgId is null!");
		}
		String created = DateUtil.getUTCTimeStr();
		String nonce = UUID.randomUUID().toString();
		return String.format(Authorization, "domain",
				Base64.encodeBase64String(ShaUtil.getSHA256(nonce + created)),
				nonce, created);
	}

	/**
	 * 请求消息头生成
	 * @param orgId 公司ID
	 * @param userId 申请用户ID
	 * @return
	 */
	protected static String GenerateAuthorization(Long orgId,Long userId){
        /*
         请求消息头说明:
          namespace:公司域名
          PasswordDigest:根据公式 PasswordDigest = Base64 (SHA256 (Nonce + Created + AppSecret))生成。
          Nonce:发送请求时生成的一个随机字符串，商户系统产生。 例如:66C92B11FF8A425FB8D4CCFE0ED9ED1F。
          Created:请求时间。标准 UTC 时间(注:UTC 时间比北京时间 晚 8 个小时)，格式为 YYYY-MM-DD'T'hh:mm:ss'Z'。例如:2014-01-07T01:58:21Z。10分钟后超时
          例如："namespace":"wsk1.findest.com","passwordDigest":"cGFd7kfftnHW8npwz4QD38aSYv3HZtQYYkIe9taZcR4=","nonce":"284e40be-afc3-4df1-b77c-abd77a5b2c24","created":"2017-06-20T06:25:48Z", userId:2
        */
		if(Validator.isNull(orgId)){
			throw new RestException("orgId is null!");
		}
		String created = DateUtil.getUTCTimeStr();
		String nonce = UUID.randomUUID().toString();
		return String.format(Authorization, "null",
				Base64.encodeBase64String(ShaUtil.getSHA256(nonce + created)),
				nonce, created,userId);
	}

    protected HttpEntity getHttpEntity(Object vo){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(com.google.common.net.HttpHeaders.ACCEPT_CHARSET, "UTF-8");
        headers.set(com.google.common.net.HttpHeaders.CONTENT_TYPE, MediaTypes.JSON_UTF_8);

        return new HttpEntity(vo, headers);
    }


	protected HttpEntity getHttpEntity(Object vo, String authorization){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(com.google.common.net.HttpHeaders.ACCEPT_CHARSET, "UTF-8");
		headers.set(com.google.common.net.HttpHeaders.CONTENT_TYPE, MediaTypes.JSON_UTF_8);
		headers.set(com.google.common.net.HttpHeaders.AUTHORIZATION,authorization);

//		System.out.println("authorization:"+authorization);

		if(vo!=null) {
			return new HttpEntity(vo, headers);
		}else{
			return new HttpEntity(headers);
		}
	}


	protected static void throwJsonException(String json){
		if(Validator.isNull(json)){
			throw new RestException("error msg is null!");
		}
//        json = "{\"msg\":\"tableId or namespace not exist!\",\"code\":\"10006\"}";
		json = json.replaceAll("\\\\", "");
		if(json.startsWith("\"")&&json.endsWith("\"")) {
			json = json.substring(1, json.length() - 1);
		}
		Map<String,String> response = mapper.fromJson(json,HashMap.class);
		if(response.get(MobileKey.CODE)!=null && response.get(MobileKey.MSG)!=null){
			throw new RestException(response);
		}else{
			response = Maps.newHashMap();
			response.put(MobileKey.CODE, BusinessStatus.ERROR);
			response.put(MobileKey.MSG, json);
			throw new RestException(response);
		}
	}

	public static void throwException(String code,String msg) {
		Map<String,String> result = Maps.newHashMap();
		result.put("code", code);
		result.put("msg", msg);
		throw new RestException(result);
	}

}
