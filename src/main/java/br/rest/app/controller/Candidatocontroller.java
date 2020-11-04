package br.rest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.rest.app.model.Candidato;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/candidatos")
public class Candidatocontroller { 

    @PostMapping
    public ResponseEntity criar(@RequestBody Candidato candidato) { 
    	
    	
    	if (candidato.getNome() == "")    	
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado.");
    	else if (candidato.getNumero() == "")
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Numero não informado.");
    	else if (candidato.getId() == null)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id não informado.");
    	else if (candidato.getTipo() == "")
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo não informado.");
    	else
    		return ResponseEntity.status(HttpStatus.CREATED).body("candidato criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity listar() {
    	    	
    	List<Candidato> lista = new ArrayList<Candidato>();
    	
    	Candidato c = new Candidato();
    	c = new Candidato();
    	c.setNome("josé");
    	c.setNumero("4456");
    	c.setTipo("Vereador");
    	c.setId(2L);
    	lista.add(c);
    	
    	c = new Candidato();
    	c.setNome("Tiririca");
    	c.setNumero("2222");
    	c.setTipo("Deputado");
    	c.setId(6L);
    	lista.add(c);
    	
    	c = new Candidato();
    	c.setNome("Arthur");
    	c.setNumero("7865");
    	c.setTipo("deputado");
    	c.setId(3L);
    	lista.add(c);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity byId(@PathVariable Long id) {    	  	
    	
    	Candidato c = new Candidato();
    	c.setId(1L);
    	c.setNome("Abreu");
    	c.setNumero("5632");
    	c.setTipo("Vereador");
    
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@RequestBody Candidato candidato, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(candidato);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}