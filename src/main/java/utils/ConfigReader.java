package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    static Properties props = new Properties();

    public static String getProperty(String key) {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            props.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return props.getProperty(key);
    }
}