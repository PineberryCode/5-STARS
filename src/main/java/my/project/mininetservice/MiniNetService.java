package my.project.mininetservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import my.project.mininetservice.service.UserService;


@SpringBootApplication
public class MiniNetService implements CommandLineRunner {

	@Value("${security.jwt.expiration-minutes}")
    private static long EXPIRATION_MINUTES;

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(MiniNetService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.findAllAndPrintToConsole();
	}

	/*@Bean
	public CommandLineRunner createPasswordCommand () {
		return args -> {
			System.out.println(passwordEncoder.encode("123"));
		};
	}*/
}
