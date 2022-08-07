package one.digitalinovation.cloudparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

@SpringBootApplication
public class CloudParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudParkingApplication.class, args);
	}

}
