package my.project.minihostel.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ticket {
    private String code;
    private employee idEmployee;
    private client idClient;
    private service idService;
    private Date init;
    private double total;
}
