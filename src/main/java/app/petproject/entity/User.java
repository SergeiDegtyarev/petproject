package app.petproject.entity;

import app.petproject.dto.enums.Gender;
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
    @Column(name ="gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

}
