package app.petproject.entity;

import app.petproject.dto.enums.Gender;
import app.petproject.dto.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="profiles")
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class User extends GenericEntity <Long>{

    @Column(name ="first_name")
    String firstName;
    @Column(name ="last_name")
    String lastName;
    @Column(name ="age")
    Integer age;
    @Column(name ="email")
    String email;
    @Column(name ="gender")
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Column(name ="status")
    @Enumerated(EnumType.STRING)
    ProfileStatus status;

}
