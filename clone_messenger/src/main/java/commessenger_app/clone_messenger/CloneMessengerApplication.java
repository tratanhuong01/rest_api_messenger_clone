package commessenger_app.clone_messenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CloneMessengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloneMessengerApplication.class, args);
	}

}
