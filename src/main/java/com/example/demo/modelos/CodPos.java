package com.example.demo.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class CodPos {
    @Id
    @Column(nullable = false, length = 50)
    private int cp;
    @Column(nullable = false, length = 50)
    private String municipio;
    @ManyToOne(optional = false)
    private Provincia provincia;
}
