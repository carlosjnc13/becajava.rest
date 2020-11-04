package br.rest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.rest.app.model.Eleitor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/eleitores")
public class EleitorController { 

    @PostMapping
    public ResponseEntity criar(@RequestBody Eleitor eleitor) {    	    	
    	if (eleitor.getNome()== "")    	
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado.");
    	else if (eleitor.getTitulo()=="")
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Numero de titulo Invalido!.");
    	else if (eleitor.getId()== null)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id não informado!.");
    	else
    		return ResponseEntity.status(HttpStatus.CREATED).body("eleitor criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity listar() {
    	    	
    	List<Eleitor> lista = new ArrayList<Eleitor>();
    	
    	Eleitor e = new Eleitor();
    	e.setId(3L);
    	e.setNome("Adalberto");
    	e.setTitulo("66774234");
    	lista.add(e);
    	
    	e = new Eleitor();
    	e.setId(7L);
    	e.setNome("Roberto");
    	e.setTitulo("8765422");
    	lista.add(e);
    	
    	e = new Eleitor();
    	e.setId(12L);
    	e.setNome("Ronaldo");
    	e.setTitulo("887767");
    	lista.add(e);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity byId(@PathVariable int id) {    	  	
    	
    	Eleitor e = new Eleitor();
    	e.setId(2L);
    	e.setNome("barbara");
    	e.setTitulo("4566777");
    
        return ResponseEntity.status(HttpStatus.OK).body(e);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@RequestBody Eleitor eleitor, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(eleitor);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}