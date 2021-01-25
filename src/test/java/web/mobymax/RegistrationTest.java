package web.mobymax;

import org.assertj.core.api.Assertions;
import web.mobymax.models.TeacherModel;
import org.testng.annotations.Test;
import web.BaseWebTest;
import web.mobymax.pageobjects.pages.teacherhomepage.TeacherHomePage;

public class RegistrationTest extends BaseWebTest {

    private final TeacherModel teacherModel = TeacherModel.getRandomTeacherModel();

    @Test
    public void verifyRegisterRandomTeacherAccountTest() {
        TeacherHomePage teacherHomePage = openMobymaxHomePage().getRegisterForm()
                .setRegistrationInfo(teacherModel)
                .register();

        Assertions.assertThat(teacherHomePage.isTeacherHomePageLoggedIn())
                .as("Teacher Home Page was not opened.")
                .isTrue();
    }

    @Test
    public void verifyTeacherCanSignInNewAccountTest() {
        TeacherHomePage teacherHomePage = openMobymaxHomePage().getPageHeader()
                .signIn()
                .openLoginAsATeacherTab()
                .setUserName(teacherModel.getLogin())
                .setUserPassword(teacherModel.getPassword())
                .signIn();

        Assertions.assertThat(teacherHomePage.isTeacherHomePageLoggedIn())
                .as("Teacher Home Page was not opened.")
                .isTrue();
    }
}