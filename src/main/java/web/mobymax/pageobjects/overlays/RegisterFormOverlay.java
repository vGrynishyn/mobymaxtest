package web.mobymax.pageobjects.overlays;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import web.mobymax.models.TeacherModel;
import web.mobymax.pageobjects.pages.teacherhomepage.TeacherHomePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegisterFormOverlay {

    private final SelenideElement parent = $("#registration"),
            firstNameField = parent.$(".signup-input input.first-name"),
            lastNameField = parent.$(".signup-input input.last-name"),
            stateField = parent.$(".signup-input.signup-input-state input.state"),
            schoolField = parent.$(".signup-input input.school"),
            emailAddressField = parent.$(".signup-input input.username "),
            passwordField = parent.$(".signup-input input.password "),
            registerButton = parent.$("#register-button");

    ElementsCollection statesItems = $$(".state-item"),
            schoolItems = $$(".school-item");

    @Step("Set registration data for teacher: {teacherModel}")
    public RegisterFormOverlay setRegistrationInfo(TeacherModel teacherModel) {
        setFirstName(teacherModel.getFirstName());
        setLastName(teacherModel.getLastName());
        selectState(teacherModel.getState());
        setSchoolName(teacherModel.getSchool());
        setEmailAddress(teacherModel.getLogin());
        setPassword(teacherModel.getPassword());
        return this;
    }

    @Step("Click 'Register' button")
    public TeacherHomePage register() {
        registerButton.click();
        return new TeacherHomePage();
    }

    @Step("Set teacher`s First Name : {firstName}")
    private void setFirstName(String firstName) {
        firstNameField.setValue(firstName);
    }

    @Step("Set teacher`s Last Name: {lastName}")
    private void setLastName(String lastName) {
        lastNameField.setValue(lastName);
    }

    @Step("Select State: {state}")
    private void selectState(String state) {
        stateField.click();
        statesItems.shouldHave(CollectionCondition.sizeGreaterThan(0)).find(Condition.text(state)).click();
    }

    @Step("Select School Name: {schoolName}")
    private void setSchoolName(String schoolName) {
        schoolField.setValue(schoolName);
        schoolItems.shouldHave(CollectionCondition.sizeGreaterThan(0)).find(Condition.text(schoolName)).click();
    }

    @Step("Set registration Email Address: {emailAddress}")
    private void setEmailAddress(String emailAddress) {
        emailAddressField.setValue(emailAddress);
    }

    @Step("Set teacher`s Password: {password}")
    private void setPassword(String password) {
        passwordField.setValue(password);
    }
}