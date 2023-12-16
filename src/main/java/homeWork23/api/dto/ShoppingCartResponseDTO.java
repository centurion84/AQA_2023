package homeWork23.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ShoppingCartResponseDTO {
    private BookDTO book;
    private Integer quantity;
}
