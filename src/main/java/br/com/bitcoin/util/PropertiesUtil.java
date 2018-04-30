package br.com.bitcoin.util;

import java.util.Properties;

public class PropertiesUtil {
	public static String getProperties(String key){	
		Properties props = new Properties();
		try {
			props.load(PropertiesUtil.class.getClassLoader().
				getResourceAsStream("service.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props.getProperty(key);
		}
	}
