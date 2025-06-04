package io.github.ashleysaintlouis.convidados;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class ConvidadosController {

    @GetMapping
    public List<Convidado> getConvidados() {
        List<Convidado> lista = new ArrayList<Convidado>();
        
        lista.add(new Convidado("Fulano", "5654548754"));
        lista.add(new Convidado("Cicrano", "56575448753"));

        return lista;
    }
    
    
}
