package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelos.Provincia;
import java.util.List;
import java.util.Optional;


public interface RepoProvincia extends JpaRepository<Provincia, Integer>{
    List<Provincia> findByComunidad(String comunidad);
    Optional<Provincia> findByCodigo(int codigo);
}
