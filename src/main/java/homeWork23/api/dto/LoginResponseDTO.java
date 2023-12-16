package homeWork23.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponseDTO {
    @JsonProperty("userDetails")
    UserDTO userDTO;
    private String token;
}
