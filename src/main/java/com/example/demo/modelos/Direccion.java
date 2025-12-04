package com.example.demo.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String tipovia;
    @Column(nullable = false, length = 150)
    private String nombrevia;
    @Column(nullable = false)
    private int numero;
    @ManyToOne(optional = false)
    private Usuario usuario;
    @ManyToOne(optional = false)
    private CodPos codPos;
}
