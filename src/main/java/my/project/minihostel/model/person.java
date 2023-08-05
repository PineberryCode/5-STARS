package my.project.minihostel.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class person {
    private String identity;
    private String lastname;
    private String names;
    private String contactNumber;
    private String address;
}
