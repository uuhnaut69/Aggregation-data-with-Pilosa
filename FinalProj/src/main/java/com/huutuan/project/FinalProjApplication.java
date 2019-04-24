package com.huutuan.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author uuhnaut
 *
 */
@SpringBootApplication 
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.huutuan.project"})
@EnableJpaRepositories(basePackages="com.huutuan.project.Repository")
@EnableTransactionManagement
@EntityScan(basePackages="com.huutuan.project.Entity")
public class FinalProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjApplication.class, args);
	}

}
