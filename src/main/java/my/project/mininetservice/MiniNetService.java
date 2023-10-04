package my.project.mininetservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import my.project.mininetservice.service.UserService;


@SpringBootApplication
public class MiniNetService implements CommandLineRunner {

	@Autowired
	UserService userService;

	/*@Autowired
	PasswordEncoder passwordEncoder;*/

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
