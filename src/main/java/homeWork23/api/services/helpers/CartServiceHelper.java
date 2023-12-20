package homeWork23.api.services.helpers;

import homeWork23.api.dto.BookDTO;
import homeWork23.api.dto.CartResponseDTO;
import homeWork23.api.services.CartService;
import io.restassured.response.Response;

import java.util.List;

public class CartServiceHelper extends CartService {

    public static BookDTO findBookByBookId(List<CartResponseDTO> bookItems, int targetBookId) {
        for (CartResponseDTO item : bookItems) {
            if (item.getBook().getBookId() == targetBookId) {
                return item.getBook();
            }
        }
        return null;
    }

    public static BookDTO getTargetBookObject(Integer userId, Integer bookId) {
        Response response = getCart(userId);
        List<CartResponseDTO> cart = response.jsonPath().getList("", CartResponseDTO.class);
        return findBookByBookId(cart, bookId);
    }
}
