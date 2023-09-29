package my.project.mininetservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CLIENT_TABLE", schema = "public")
@Getter
@Setter
public class Client extends Person {
    
}
