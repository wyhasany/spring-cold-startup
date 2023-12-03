package tech.paramount.cold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringColdStartupApplication {

	private static ResourceCracExample resourceCracExample;

	public static void main(String[] args) {
		resourceCracExample = new ResourceCracExample();
		SpringApplication.run(SpringColdStartupApplication.class, args);
	}
}
