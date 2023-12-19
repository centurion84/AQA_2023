package homeWork23.api.services.helpers;

import homeWork23.api.dto.BookDTO;
import homeWork23.api.services.BookService;
import io.restassured.response.Response;

import java.util.List;
import java.util.Random;

public class BookServiceHelper extends BookService {
    public static Integer getBookId() {
        Response response = getBooks();
        List<BookDTO> books = response.jsonPath().getList("", BookDTO.class);

        if (books.isEmpty()) {
            return null;
        }

        Random random = new Random();
        return books.get(random.nextInt(books.size())).getBookId();
    }
}
