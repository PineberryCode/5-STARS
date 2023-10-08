package my.project.mininetservice.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import my.project.mininetservice.config.security.filter.JWTAuthenticationFilter;
import my.project.mininetservice.util.Permission;
import my.project.mininetservice.util.Role;

@Component
@EnableWebSecurity
@EnableMethodSecurity
public class HttpSecurityConfig {
    
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JWTAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        .csrf(csrfConfig -> csrfConfig.disable())
        .sessionManagement(sessionManagementConfig -> sessionManagementConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .authorizeHttpRequests(builderRequestMatchers());
        
        return httpSecurity.build();
    }

    private static Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> builderRequestMatchers () {
        return authConfig -> {
            authConfig.requestMatchers(HttpMethod.POST, "/restricted/admin/login").permitAll();
            authConfig.requestMatchers(HttpMethod.GET, "/global/welcome").permitAll();
            authConfig.requestMatchers(HttpMethod.GET, "/global/contactUs").permitAll();
            authConfig.requestMatchers(HttpMethod.POST, "/global/contactUs/sendRecommendation").permitAll();
            authConfig.requestMatchers(HttpMethod.POST, "/global/contactUs/sendComplaint").permitAll();
            authConfig.requestMatchers(HttpMethod.POST, "/global/contactUs/sendConsultation").permitAll();
            authConfig.requestMatchers(HttpMethod.GET, "/global/services").permitAll();
            authConfig.requestMatchers(HttpMethod.GET, "/restricted/admin").permitAll(); //login

            /*
             * Static
             */
            authConfig.requestMatchers(HttpMethod.GET,"/static/global.css").permitAll();
            authConfig.requestMatchers(HttpMethod.GET,"/static/bootstrap.min.css").permitAll();
            authConfig.requestMatchers(HttpMethod.GET,"/static/js/toast.js").permitAll();
            authConfig.requestMatchers(HttpMethod.GET,"/static/img/SaitamaBelowTheRain.jpg").permitAll();
            authConfig.requestMatchers(HttpMethod.GET,"/static/font/Pirrata.otf").permitAll();
            //authConfig.requestMatchers(HttpMethod.GET, "/restricted/admin/overview").permitAll();
            authConfig.requestMatchers(HttpMethod.GET, "/static/restricted.css").hasAuthority(Permission.READ_OVERVIEW.name());
            authConfig.requestMatchers(HttpMethod.GET, "/restricted/admin/overview").hasAuthority(Permission.READ_OVERVIEW.name());

            authConfig.requestMatchers("/error").permitAll();
            authConfig.anyRequest().denyAll();
        };
    }

}
