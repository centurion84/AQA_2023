package homeWork23.api.services;

import homeWork23.api.dto.BookDTO;
import homeWork23.api.dto.ShoppingCartResponseDTO;
import io.restassured.response.Response;

import java.util.List;

public class ShoppingCartService extends BaseService {

    public static Response addToCart(Integer userId, Integer bookId) {
        return setRequestSpec()
                .given().pathParam("userId", String.valueOf(userId)).pathParam("bookId", bookId).post("/ShoppingCart/AddToCart/{userId}/{bookId}");
    }

    public static Response getCart(Integer userId) {
        return setRequestSpec()
                .given().pathParam("userId", String.valueOf(userId)).get("/ShoppingCart/{userId}");
    }

    public static boolean containsBookIdInCart(List<ShoppingCartResponseDTO> bookItemDTOList, Integer bookId) {
        return bookItemDTOList.stream()
                .anyMatch(item -> item.getBook().getBookId().equals(bookId));
    }

    public static BookDTO findBookByBookId(List<ShoppingCartResponseDTO> bookItems, int targetBookId) {
        for (ShoppingCartResponseDTO item : bookItems) {
            if (item.getBook().getBookId() == targetBookId) {
                return item.getBook();
            }
        }
        return null;
    }
}