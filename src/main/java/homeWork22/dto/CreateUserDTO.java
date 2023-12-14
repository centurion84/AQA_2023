package homeWork22.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreateUserDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
}

