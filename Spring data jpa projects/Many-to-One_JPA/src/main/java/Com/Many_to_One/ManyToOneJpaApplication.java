package Com.Many_to_One;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToOneJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManyToOneJpaApplication.class, args);

		System.out.println("Application Started");
	}

}
