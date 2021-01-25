package web;

import com.codeborne.selenide.Selenide;
import engine.DriverBinaryManager;
import engine.DriverConfigurator;
import engine.DriverUtils;
import lombok.extern.java.Log;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.TestListener;
import web.mobymax.pageobjects.pages.homepage.HomePage;
import java.time.LocalDateTime;

@Log
@Listeners(TestListener.class)
public class BaseWebTest {

    public HomePage openMobymaxHomePage() {
        Selenide.open("https://www.mobymax.com/");
        return new HomePage();
    }

    @BeforeSuite
    protected void beforeSuite(ITestContext context) {
        DriverBinaryManager.setupWebDriverBinary();
    }

    @BeforeMethod(description = "Initialize web driver configuration")
    protected void beforeMethod() {
        DriverConfigurator.configure();
    }

    @AfterMethod(alwaysRun = true, description = "Close driver")
    protected void tearDown() {
        System.out.println(LocalDateTime.now());
        DriverUtils.stop();
    }
}