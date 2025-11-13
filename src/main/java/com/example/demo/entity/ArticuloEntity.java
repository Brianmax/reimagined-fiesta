package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articulos")
@Getter
@Setter
public class ArticuloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "articulo_id")
    private int articuloId;
    private String titulo;
    private String contenido;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion = new Date();
    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;
    @Column(name = "url_articulo")
    private String urlArticulo;

    @ManyToOne()
    @JoinColumn(name = "usuario_id_fk")
    private UsuarioEntity usuario;

    @ManyToMany(mappedBy = "articulos", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CategoriaEntity> categorias;
}

// DTO: DATA TRANSFER OBJECT
