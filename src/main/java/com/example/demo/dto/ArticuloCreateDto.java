package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticuloCreateDto {
    private String titulo;
    private String contenido;
    private int usuarioId;
}
