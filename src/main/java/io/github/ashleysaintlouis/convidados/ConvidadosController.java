package io.github.ashleysaintlouis.convidados;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class ConvidadosController {
    @Autowired
    ConvidadoRepository repository;

    @GetMapping
    public List<Convidado> getConvidados() {
        return repository.findAll();
    }
    
    
}
