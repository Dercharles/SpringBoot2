package com.yang.common.base.service;

import com.yang.common.base.entity.IdEntity;
import com.yang.common.base.vo.BaseVo;
import com.yang.common.modules.mapper.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BusinessLogger {
	// 业务日志的logger
	private static Logger businessLogger = LoggerFactory.getLogger("business");
	
	private static JsonMapper mapper = JsonMapper.nonDefaultMapper();

	public static void log(String action, String user, Map data) {
		businessLogger.info(mapper.toJson(data), action, user, data);
	}
	
	public static void log(String action, String user, IdEntity data) {
		businessLogger.info(mapper.toJson(data), action, user, data);
	}
	
	public static void log(String action, String user, BaseVo data) {
		System.out.println(mapper.toJson(data));
		businessLogger.info(mapper.toJson(data), action, user, data);
	}
	

}
