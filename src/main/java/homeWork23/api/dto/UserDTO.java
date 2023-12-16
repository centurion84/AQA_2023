package homeWork23.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDTO {
    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String gender;
    private int userTypeId;
}
