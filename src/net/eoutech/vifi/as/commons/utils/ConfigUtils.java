package net.eoutech.vifi.as.commons.utils;

import java.util.ResourceBundle;

/**
 * Created by Administrator on 2015/8/19.
 * 配置文件可来源于
 * - 配置文件 application.properties (出厂值）
 * - 数据库（用户配置）
 * - 启动参数 args （调试用）
 * 
 */

public class ConfigUtils 
{
	//Singleton
	private static ConfigUtils instance;
	
	private ConfigUtils()  
	{ 
		readAppCfg(); 
	}
	
	public static ConfigUtils getInstance() 
	{
		if (instance == null) {
			instance = new ConfigUtils();
		}
		return instance;
	}	
 
	
	private ResourceBundle appCfg = null;
	
	
	public int init(String[] args)
	{
		//parse args TODO
		//read from database
		return 0;
	}
	
	
	
	public int readAppCfg()
	{
		try {
			appCfg = ResourceBundle.getBundle("application");
			return 0;
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return -1;
	}
	
	
	
	public int reload()
	{
		//TODO
		return -1;
	}
	
	
	
	public String getCfgStr(String key) 
	{
		String value = null;
		if (appCfg != null) {
			try {
				value = appCfg.containsKey(key) ? appCfg.getString(key) : "";
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return (value==null ? "" : value);
	}
	
	
	public int getCfgInt(String key)
	{
		int value = -1;
		try {
			value =  Integer.parseInt(getCfgStr(key));
		}catch(Exception e) {
			//IGNORE
		}
		return value;
	}
	
	public String[] getCfgArray(String key) 
	{
		if (appCfg != null) {
			try {
				return appCfg.containsKey(key) ? appCfg.getStringArray(key) : null;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
