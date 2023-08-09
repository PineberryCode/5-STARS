package my.project.mininetservice.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ticket {
    private String code;
    private employee idEmployee;
    private client idClient;
    private ownService idService;
    private Date init;
    private double total;
}
