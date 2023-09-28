package my.project.mininetservice.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

enum Gender {
    MALE,
    FEMALE
}

@Getter
@Setter
public class Employee extends Person {
    private JobRole roleAndSalary;
    private String workShift;
    private Date birthDate;
    private Gender gender;
    private String nacionality;
    private Date joining;
    private String emergencyContact;
}
