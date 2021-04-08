package org.poly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import fileConfig.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class EColeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EColeBackendApplication.class, args);
	}
	

}
