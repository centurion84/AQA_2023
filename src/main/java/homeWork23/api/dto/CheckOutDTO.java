package homeWork23.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CheckOutDTO {
    public String orderId;
    public List<OrderDetailsDTO> orderDetails;
    public int cartTotal;
    public String orderDate;
}

