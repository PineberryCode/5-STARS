package my.project.mininetservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class TokenJWT {

    private User user;
    
    private String token;
    private String expirationTime;

    public TokenJWT() {
        user = new User();
        //user.setUsername("admin");
        //user.setPassword("123");
    }
}
