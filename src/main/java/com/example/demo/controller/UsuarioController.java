package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelos.Rol;
import com.example.demo.modelos.Usuario;
import com.example.demo.repositorios.RepoUsuario;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/admin")
public class UsuarioController {
    @Autowired
    RepoUsuario repoUsuario;

    @GetMapping("/Saluda")
    public String getMethodName(@RequestParam String nombre, Model modelo) {
        modelo.addAttribute("mensaje", "hola");
        modelo.addAttribute("nombre", nombre);
        return "salida";
    }

    @PostMapping("/Saluda")
    public String postMethodName(@RequestBody String nombre, Model modelo) {
        modelo.addAttribute("mensaje", "hola mundo");
        modelo.addAttribute("nombre", nombre);
        return "saluda";
    }
    
    @GetMapping("/inserta")
    public String getMethodName(Model modelo) {
        Usuario u = new Usuario();
        u.setEmail("pepe@educa.es");
        u.setNif("123456F");
        u.setPassword("zapato");
        u.setRol(Rol.CLIENTE);
        u.setTelefono(543626271);
        u.setUsername("pepe");

        repoUsuario.save(u);

        modelo.addAttribute("mensaje", "Insertando Usuario");
        modelo.addAttribute("nombre", u.getUsername());


        return "saluda";
    }




}
