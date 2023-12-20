package homeWork23.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookDTO {

    private Integer bookId;
    private String title;
    private String author;
    private String category;
    private Float price;
    private String coverFileName;
}
