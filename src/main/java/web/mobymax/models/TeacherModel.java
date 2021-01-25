package web.mobymax.models;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TeacherModel {
    String firstName;
    String lastName;
    String state;
    String school;
    String login;
    String password;

    public static TeacherModel getRandomTeacherModel() {
        Faker faker = new Faker();
        return TeacherModel.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .state("California")
                .school("AQA Test School")
                .login(faker.bothify("???@wtfqa.ua"))
                .password(faker.internet().password())
                .build();
    }
}