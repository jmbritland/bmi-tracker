package com.jbritland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BmiCalculatorApplication {
	
	public static String apiUrl = "https://62aec310-48ee-44d1-82cd-84a241a1e98a.mock.pstmn.io";

	public static void main(String[] args) {
		SpringApplication.run(BmiCalculatorApplication.class, args);
	}

}
