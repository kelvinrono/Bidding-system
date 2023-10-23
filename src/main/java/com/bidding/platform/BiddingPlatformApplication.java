package com.bidding.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableScheduling

public class BiddingPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiddingPlatformApplication.class, args);
	}

}
