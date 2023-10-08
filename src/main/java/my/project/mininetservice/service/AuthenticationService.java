package my.project.mininetservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextHolderFilter;
import org.springframework.stereotype.Service;

import my.project.mininetservice.dto.AuthenticationRequest;
import my.project.mininetservice.dto.AuthenticationResponse;
import my.project.mininetservice.model.User;
import my.project.mininetservice.model.repository.UserRepository;

@Service
public class AuthenticationService {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    public AuthenticationResponse login (AuthenticationRequest authenticationRequest) {
        User user = userRepository.findByUsername(authenticationRequest.getUsername()).get();
        
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
            authenticationRequest.getUsername(), authenticationRequest.getPassword()//,
            //user.getAuthorities() //Testing
        ); //Authencate just username and password.
        authenticationManager.authenticate(authToken);
        //System.out.println("Authorities: "+authToken.getAuthorities());
        
        //Checked System.out.println("From AuthenticationResponse: "+user.getUsername()+"Role: "+user.getUser_role().getPermissions());
        SecurityContextHolder.getContext().setAuthentication(authToken);
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Usuario autenticado: " + authentication.getName());
        System.out.println("Roles: " + authentication.getAuthorities());
        
        /*System.out.println("Usuario  02: " + authentication.getName());
        System.out.println("Roles 02: " + authentication.getAuthorities());*/
        //authentication.setAuthenticated(false);
        //Checked System.out.println("From Auth JWT -> "+jwt);
        //SecurityContextHolder.getContext().setAuthentication(authToken); //<--
        //SecurityContextHolder.getContext().setAuthentication(authToken);
        return new AuthenticationResponse(jwt);
    }

    private Map<String, Object> generateExtraClaims (User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("user_role", user.getUser_role().name());
        extraClaims.put("permissions", user.getAuthorities());

        return extraClaims;
    }

}
