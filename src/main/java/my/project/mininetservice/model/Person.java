package my.project.mininetservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Person {
    @Id
    private Long identity;
    private String lastname;
    private String names;
    private String contactNumber;
    private String email;
    private String address;
}
