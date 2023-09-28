package my.project.mininetservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnService {
    private int code;
    private String idEmployee;
    private int technology; //wan, fibra, satelite
    private String uploadSpeed;
    private String downloadSpeed;
    private boolean contract;
    private String velocity;
    private double price;
}
