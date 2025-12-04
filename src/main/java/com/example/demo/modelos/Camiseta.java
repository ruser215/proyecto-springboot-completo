package com.example.demo.modelos;


import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Camiseta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Talla talla;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Column(nullable = false, length = 50)
    private String color;
    @Column(nullable = false, length = 50)
    private String marca;
    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private int stock;
    @Column(nullable = false, columnDefinition = "DECIMAL(8,2)")
    private BigDecimal precio;
    @Column(columnDefinition = "TINYINT(1)")
    private int activo;

    @ManyToOne(optional = false)
    private Estilo estilo;
}
