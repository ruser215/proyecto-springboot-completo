package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelos.Provincia;
import com.example.demo.repositorios.RepoProvincia;

import lombok.NonNull;

@Controller
@RequestMapping("/admin/provincia")
public class ProvinciaController {
    @Autowired
    RepoProvincia RepoProvincia;

    @GetMapping("")
    public String findAll(Model modelo) {
        modelo.addAttribute("titulo", "Listado de Provincias");
        modelo.addAttribute("listaProvincias", RepoProvincia.findAll());
        return "provincia/list";
    }

    @GetMapping("/add")
    public String add(Model modelo) {
        modelo.addAttribute("accion", "Añadir");
        modelo.addAttribute("provincia", new Provincia());
        return "provincia/create";
    }
    
    @PostMapping("/add")
    public String add(
        @ModelAttribute("provincia") Provincia provincia) {
            RepoProvincia.save(provincia);
            return "redirect:/admin/provincia";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable @NonNull Integer id, Model modelo) {
        Optional<Provincia> oProvincia = RepoProvincia.findByCodigo(id);
        System.out.println("Estos son los datos de oProvincia" + oProvincia);
        if (oProvincia.isPresent()){     
            modelo.addAttribute("accion", "Editar");   
            modelo.addAttribute("provincia", oProvincia.get());
            return "provincia/edit";
        }else{
            modelo.addAttribute("titulo", "Gestion de Provincias");
            modelo.addAttribute("mensaje", "Esa provincia no existe");
            return "error";
        }
    }

    @PostMapping("/edit/{id}")
    public String edit(
        @ModelAttribute("provincia") Provincia provincia,
        @PathVariable(name = "id") @NonNull Integer codigo) {
            //Esto lo que hace es asegurar que el el ide es el correct
            provincia.setCodigo(codigo);
            // y qui ya los solapa
            RepoProvincia.save(provincia);
            return "redirect:/admin/provincia";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable @NonNull Integer id, Model modelo) {
        Optional<Provincia> oProvincia = RepoProvincia.findByCodigo(id);
        System.out.println("Estos son los datos de oProvincia" + oProvincia);
        if (oProvincia.isPresent()){        
            modelo.addAttribute("accion", "borrar");
            modelo.addAttribute("provincia", oProvincia.get());
            return "provincia/del";
        }else{
            modelo.addAttribute("titulo", "Gestion de Provincias");
            modelo.addAttribute("mensaje", "Esa provincia no existe");
            return "error";
        }
    }

    @PostMapping("/del/{id}")
    public String del(
        @ModelAttribute("provincia") Provincia provincia,
        @PathVariable(name = "id") @NonNull Integer codigo) {
            RepoProvincia.deleteById(codigo);;
            return "redirect:/admin/provincia";
    }


}
