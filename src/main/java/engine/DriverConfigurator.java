package engine;

import com.codeborne.selenide.Configuration;
import engine.webdriver.*;
import java.time.Duration;

public final class DriverConfigurator {

    public static void configure() {
        Configuration.timeout = Duration.ofSeconds(20).toMillis();
        Configuration.startMaximized = true;
        Configuration.reopenBrowserOnFail = true;
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        Configuration.browser = getDriverClassName();
    }

    private static String getDriverClassName() {
        return ChromeDriverProvider.class.getName();
    }
}