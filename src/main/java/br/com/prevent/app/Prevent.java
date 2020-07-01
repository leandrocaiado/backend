    package br.com.prevent.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Prevent extends SpringBootServletInitializer {
   public static void main(String[] args) {
      SpringApplication.run(Prevent.class, args);
   }}