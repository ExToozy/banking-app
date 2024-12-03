package ru.extoozy.eventhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = "ru.extoozy")
@EntityScan(basePackages = "ru.extoozy")
@EnableJpaRepositories(basePackages = "ru.extoozy")
@EnableTransactionManagement
public class EventHandlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventHandlerApplication.class, args);
    }
}
