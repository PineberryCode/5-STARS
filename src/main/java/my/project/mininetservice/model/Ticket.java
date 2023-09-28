package my.project.mininetservice.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
    private String code;
    private Employee idEmployee;
    private Client idClient;
    private OwnService idService;
    private Date init;
    private double total;
}
