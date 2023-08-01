package my.project.minihostel.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class room {
    private int code;
    private String floor;
    private String capacity;
    private double price;
}
