package com.learn.store.services;

import com.learn.store.models.Persona;
import com.learn.store.repositories.PersonaReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    PersonaReposity personaReposity;

    public List<Persona> listarTodas (){
        return personaReposity.findAll();
    }

    public Persona guardarPersona (Persona persona){
        return personaReposity.save(persona);
    }

    public Optional<Persona> obtenerPorId (Long id){
        return personaReposity.findById(id);
    }

    public void eliminarPorId (Long id){
        personaReposity.deleteById(id);
    }
}

