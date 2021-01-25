package web.mobymax.pageobjects.pages.teacherhomepage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TeacherHomePage {

    private final SelenideElement parent = $("#root"),
        pageHeader = parent.$x("//div[contains(@class, 'header--AppBarContainer')]"),
        moreButton = pageHeader.$x(".//span[contains(text(), 'More')]/ancestor::button"),
        logoutButton = $$("[role='menuitem']").find(Condition.text("Log Out"));

    @Step("Verify is teacher logged")
    public boolean isTeacherHomePageLoggedIn(){
        moreButton.click();
        return logoutButton.exists();
    }
}