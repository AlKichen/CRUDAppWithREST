package ru.kata.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Пользователь в роли админа:
 * логин: "admin@ya.ru"
 * пароль: "admin"
 *
 * Пользователь в роли пользователя:
 * логин: "user@ya.ru"
 * пароль: "user"
 */

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
    }

}
