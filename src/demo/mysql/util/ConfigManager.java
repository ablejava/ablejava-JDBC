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
			//��ȡ�����ļ�
			//properties.load(InputStream);��ȡ�ļ�
			properties.load(in);
			in.close();//�����ر�
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ͨ������ģʽ����ʵ�����ĸ���
	 * @return
	 */
	public static ConfigManager getInstance(){
		if (configManager==null) {
			configManager=new ConfigManager();
		}
		return configManager;
	}
	/**
	 * ��database.properties�ܸ���key�õ���Ӧ��valueֵ
	 */
	public String getString(String key){
		return properties.getProperty(key);
	}

}
