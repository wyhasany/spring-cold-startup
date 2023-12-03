package tech.paramount.cold;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class ClassDataSharingConfig {

    Logger log = LoggerFactory.getLogger(ClassDataSharingConfig.class);

    @Bean
    @Profile("cds")
    ApplicationRunner applicationRunner(ApplicationContext applicationContext) {
        return args -> {
            log.info("Application stopped for CDS generation");
            SpringApplication.exit(applicationContext, () -> 0);
        };
    }
}
