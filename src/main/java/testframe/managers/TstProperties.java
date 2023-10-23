package testframe.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class TstProperties {

    private final Properties properties = new Properties();

    private static TstProperties instance = null;

    private TstProperties() {

        loadProperties();
    }

    public static TstProperties getProperty() {
        if (instance == null) {
            instance = new TstProperties();
        }
        return instance;
    }

    private void loadProperties() {
        try {
            properties.load(new FileInputStream("src/properties.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}