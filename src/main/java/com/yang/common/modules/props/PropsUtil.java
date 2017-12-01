package com.yang.common.modules.props;

import com.yang.common.modules.utils.PropertiesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropsUtil {
	private static Logger _log = LoggerFactory.getLogger(PropsUtil.class);
	
	protected static PropertiesLoader propertiesLoader = new PropertiesLoader("classpath:/application.properties");
	protected static PropertiesLoader propertiesLoaderFunctional = new PropertiesLoader("classpath:/application-functional.properties");
	protected static PropertiesLoader propertiesLoaderLocal = new PropertiesLoader("classpath:/application-local.properties");
	
	public static String getProperty(String key) {
		String property ;

        try {
            property = propertiesLoader.getProperty(key);
        }catch (Exception e){
            _log.debug("Property key not exit: "+key);
            return null;
        }

		try{
			if(propertiesLoaderFunctional!=null){
				property = propertiesLoaderFunctional.getProperty(key);
			}
			
		}catch(Exception e){
			_log.debug("propertiesLoaderFunctional not exit",e.getMessage());
		}
		
		try{
			if(propertiesLoaderLocal!=null){
				property = propertiesLoaderLocal.getProperty(key);
			}
			
		}catch(Exception e){
			_log.debug("propertiesLoaderLocal not exit",e.getMessage());
		}
	
		return property;
	}
	
	public static String getProperty(String key, String value) {
		if (propertiesLoader.getProperty(key) == null )
			return value;
		return propertiesLoader.getProperty(key);
	}

}
