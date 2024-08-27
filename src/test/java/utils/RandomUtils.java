package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    Faker faker = new Faker(new Locale("en-GB"));
    public String
            randomEmail = faker.internet().emailAddress(),
            randomPassword = faker.internet().password();
}
