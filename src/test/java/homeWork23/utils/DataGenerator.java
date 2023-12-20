package homeWork23.utils;

import com.github.javafaker.Faker;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DataGenerator {
    public static final Faker faker = new Faker();

    public static String randomGender() {
        return faker.options().option("male", "female");
    }

    public static String randomPassword() {
        return faker.internet().password(8, 16, true, true, true);
    }

    public static String randomUserName() {
        return faker.name().firstName().toLowerCase() + "_" + faker.number().numberBetween(2, 99);
    }

    public static String randomFullName() {
        return faker.name().fullName();
    }

    public static String randomLastName() {
        return faker.name().lastName();
    }

    public static String randomFirstName() {
        return faker.name().firstName();
    }

    public static int randomIntId() {
        return faker.number().numberBetween(100000, 999999);
    }

    public static String randomStringId() {
        return String.valueOf(faker.number().numberBetween(100000, 999999));
    }

    public static String randomAddress() {
        return faker.address().streetAddress();
    }

    public static String randomState() {
        return faker.address().state();
    }

    public static String currentFormattedTime() {
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        return now.format(DateTimeFormatter.ISO_INSTANT);
    }
}
