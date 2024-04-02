package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTableUrl() {
        return properties.getProperty("table.test.website.url");
    }

    public String getMenuUrl() {
        return properties.getProperty("menu.test.website.url");
    }

    public String getChromeDriverPath() {
        return properties.getProperty("chrome.driver.path");
    }

    public String getReportFilePath() {
        return properties.getProperty("report.file.path");
    }

    public int getSearchColumn() {
        return Integer.parseInt(properties.getProperty("search.column"));
    }

    public String getSearchText() {
        return properties.getProperty("search.text");
    }

    public int getReturnColumn() {
        return Integer.parseInt(properties.getProperty("return.column"));
    }

    public String getExpectedText() {
        return properties.getProperty("expected.text");
    }

    public String getMenuItem() {
        return properties.getProperty("menu.item");
    }

    public String getSubMenuItem() {
        return properties.getProperty("sub.menu.item");
    }
}
