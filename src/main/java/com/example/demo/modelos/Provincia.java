package com.example.demo.modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Provincia {
    @Id
    private Integer codigo;
    private String comunidad;
    @Column(nullable = false, length = 50)
    private String nombre;

    @OneToMany(mappedBy = "provincia")
    private List<CodPos> codpos;
    
}
