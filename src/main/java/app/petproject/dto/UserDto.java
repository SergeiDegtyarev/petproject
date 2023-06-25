package app.petproject.dto;


import app.petproject.dto.enums.Gender;
import app.petproject.dto.enums.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("last_name")
    String lastName;
    @JsonProperty("email")
    String email;
    @JsonProperty("age")
    Integer age;
    @JsonProperty("gender")
    Gender gender;
    @JsonIgnore
    ProfileStatus status;

}
