package com.learn.store.controllers;

import com.learn.store.models.Persona;
import com.learn.store.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping
    public String listaPersonas (Model model){
        model.addAttribute("personas", personaService.listarTodas());
        return "persona-list";
    }

    @GetMapping("/nuevo")
    public String formNuevaPersona (Model model){
        model.addAttribute("persona", new Persona());
        return "persona-form";
    }

    @PostMapping
    public String guardarPersona (Persona persona) {
        personaService.guardarPersona(persona);
        return "redirect:/personas";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarPersona (@PathVariable Long id, Model model){
        model.addAttribute("persona", personaService.obtenerPorId(id));
        return "persona-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona (@PathVariable Long id){
        personaService.eliminarPorId(id);
        return "redirect:/personas";
    }
}
