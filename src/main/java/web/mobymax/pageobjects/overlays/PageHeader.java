package web.mobymax.pageobjects.overlays;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import web.mobymax.pageobjects.pages.signinpage.SignInPage;

import static com.codeborne.selenide.Selenide.$;

public class PageHeader {

    private final SelenideElement parent = $("#header"),
            signInButton = parent.$(".btn-signin");

    @Step("Click SignIn Button")
    public SignInPage signIn(){
        signInButton.click();
        return new SignInPage();
    }

}
