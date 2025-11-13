package com.example.demo.controller;

import com.example.demo.entity.ArticuloEntity;
import com.example.demo.service.ArticuloService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/articulo")
public class ArticuloController {
    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @PostMapping("/save")
    public ArticuloEntity save(@RequestBody ArticuloEntity articulo) {
        return articuloService.create(articulo);
    }
}
