package engine;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverBinaryManager {

    public static void setupWebDriverBinary() {
        WebDriverManager.chromedriver().setup();
    }
}