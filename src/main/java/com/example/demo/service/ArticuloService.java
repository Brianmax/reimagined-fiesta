package com.example.demo.service;

import com.example.demo.dto.ArticuloCreateDto;
import com.example.demo.entity.ArticuloEntity;

import java.util.List;

public interface ArticuloService {
    ArticuloEntity create(ArticuloCreateDto articulo);
    List<ArticuloEntity> findAll();
    ArticuloEntity findById(Integer id);
    ArticuloEntity update(ArticuloEntity articulo, int id);
    void delete(int id);
}
