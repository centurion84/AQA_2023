package homeWork23.api.services;

import homeWork23.api.dto.BookDTO;
import io.restassured.response.Response;

import java.util.List;
import java.util.Random;

public class BookService extends BaseService {

    public static Response getBooks() {
        return setRequestSpec()
                .given()
                .get("/Book");
    }

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

