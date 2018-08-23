package de.DataCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		/** Test implementation for the JSON LD-Library 
		 * TODO: Gives back several errors, which need to be fixed.
		 **/
		//JSON_LD jsonLD = new JSON_LD();
	}
}
