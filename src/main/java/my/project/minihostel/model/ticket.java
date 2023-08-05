package my.project.minihostel.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ticket {
    private String code;
    private employee idEmployee;
    private guest idGuest;
    private room idRoom;
    private Date init;
    private double total;
}
