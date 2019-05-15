package org.cwjweixin.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("org.cwjweixin")
@EntityScan("org.cwjweixin")
@EnableJpaRepositories("org.cwjweixin")
public class WeixinApplication implements CommonsConfig {
	
	public static void main(String[] args) {
		SpringApplication.run(WeixinApplication.class, args);
	}
	
}
