package homeWork23.utils;

import homeWork23.api.dto.BookDTO;
import homeWork23.api.dto.CheckOutDTO;
import homeWork23.api.dto.OrderDetailsDTO;
import homeWork23.api.dto.UserDTO;

import java.util.Collections;

import static homeWork23.utils.DataGenerator.*;

public class TestData {

    public static UserDTO randomUserData() {
        return UserDTO.builder()
                .userId(0)
                .firstName(randomFirstName())
                .lastName(randomLastName())
                .username(randomUserName())
                .password(randomPassword())
                .gender(randomGender())
                .userTypeId(randomIntId())
                .build();
    }

    public static UserDTO emptyUserData() {
        return UserDTO.builder()
                .userId(0)
                .firstName("")
                .lastName("")
                .username("")
                .password("")
                .gender("")
                .userTypeId(0)
                .build();
    }

    public static CheckOutDTO checkoutBody(BookDTO targetBook) {
        OrderDetailsDTO orderDetail = OrderDetailsDTO.builder()
                .book(targetBook)
                .quantity(1)
                .build();

        return CheckOutDTO.builder()
                .orderId(randomStringId())
                .orderDetails(Collections.singletonList(orderDetail))
                .cartTotal(1)
                .orderDate(currentFormattedTime())
                .build();
    }
}
