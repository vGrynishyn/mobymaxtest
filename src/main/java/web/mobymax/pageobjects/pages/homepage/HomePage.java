package web.mobymax.pageobjects.pages.homepage;

import io.qameta.allure.Step;
import web.mobymax.pageobjects.overlays.PageHeader;
import web.mobymax.pageobjects.overlays.RegisterFormOverlay;

public class HomePage {

    @Step("Get Register Form.")
    public RegisterFormOverlay getRegisterForm(){
        return new RegisterFormOverlay();
    }

    @Step("Get Page Header")
    public PageHeader getPageHeader(){
        return new PageHeader();
    }
}