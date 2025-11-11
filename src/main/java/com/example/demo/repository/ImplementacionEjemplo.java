package com.example.demo.repository;

public class ImplementacionEjemplo implements Ejemplo{
    @Override
    public void hola() {
        System.out.println("Hola desde otra clase");
    }
}
