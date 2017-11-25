package com.renovation_man.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.renovation_man")
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.renovation_man"})
@EnableJpaRepositories(basePackages = {"com.renovation_man"})
@EnableTransactionManagement
public class Application extends SpringBootServletInitializer {

	
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
        
    }

}
