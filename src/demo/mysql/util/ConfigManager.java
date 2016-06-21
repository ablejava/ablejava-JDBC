package demo.mysql.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	private static ConfigManager configManager;
	private static Properties properties;
	private ConfigManager(){
		String configFile="database.properties";
		try {
			properties=new Properties();
			InputStream in=ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
			//读取配置文件
			//properties.load(InputStream);读取文件
			properties.load(in);
			in.close();//将流关闭
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 通过单例模式设置实例化的个数
	 * @return
	 */
	public static ConfigManager getInstance(){
		if (configManager==null) {
			configManager=new ConfigManager();
		}
		return configManager;
	}
	/**
	 * 在database.properties总根据key得到对应的value值
	 */
	public String getString(String key){
		return properties.getProperty(key);
	}

}
