package web.mobymax.pageobjects.pages.signinpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import web.mobymax.pageobjects.overlays.LoginAsATeacherOverlay;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    private final SelenideElement parent = $(".inner-wrapper .form-contents"),
            loginAsATeacherTab = parent.$(".header-menu-item.item-T");

    @Step("Open Login As Teacher Tab.")
    public LoginAsATeacherOverlay openLoginAsATeacherTab() {
        loginAsATeacherTab.shouldHave(Condition.visible).click();
        return new LoginAsATeacherOverlay();
    }
}