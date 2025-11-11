package com.example.demo;

import com.example.demo.entity.ArticuloEntity;
import com.example.demo.repository.Ejemplo;
import com.example.demo.repository.EjemploImpl;
import com.example.demo.repository.ImplementacionEjemplo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
