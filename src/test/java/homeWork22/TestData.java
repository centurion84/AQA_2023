package homeWork22;

import com.github.javafaker.Faker;
import homeWork22.dto.CreateUserDTO;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Random;

public class TestData {
    public static CreateUserDTO createDefaultUser() {
        Faker faker = new Faker();
        return CreateUserDTO.builder()
                .name(faker.name().firstName())
                .job(faker.job().title())
                .build();
    }

    public static int randomId() {
        Random rand = new Random();
        return rand.nextInt(90000) + 10000;
    }

    public static boolean isTimeFresh(String time) {
        ZonedDateTime creationDate = ZonedDateTime.parse(time);
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);

        return creationDate.isBefore(now.plusSeconds(5)) && creationDate.isAfter(now.minusSeconds(5));
    }
}
