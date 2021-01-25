package web.mobymax.pageobjects.overlays;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import web.mobymax.pageobjects.pages.teacherhomepage.TeacherHomePage;

import static com.codeborne.selenide.Selenide.$;

public class LoginAsATeacherOverlay{

    private final SelenideElement parent = $(".screen-2"),
        userNameInputField = parent.$("#UserUsername"),
        userPasswordInputField = parent.$("#UserPassword"),
        signInButton = parent.$(".signin-form-button");

    @Step("Set Teacher`s Login Name: {userName}")
    public LoginAsATeacherOverlay setUserName(String userName){
        userNameInputField.setValue(userName);
        return this;
    }

    @Step("Set Teacher`s Password: {userPassword}")
    public LoginAsATeacherOverlay setUserPassword(String userPassword){
        userPasswordInputField.setValue(userPassword);
        return this;
    }

    @Step("Click SignIn button")
    public TeacherHomePage signIn(){
        signInButton.click();
        return new TeacherHomePage();
    }
}