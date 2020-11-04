package br.rest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.rest.app.model.Zona;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zonas")
public class ZonaController { 

    @PostMapping
    public ResponseEntity criar(@RequestBody Zona zona ) {    	    	
    	if (zona.getNumero()== "")    	
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado.");
    	else if (zona.getId()== null)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id Invalido.");
    	else
    		return ResponseEntity.status(HttpStatus.CREATED).body("Zona criada com sucesso!");
    }

    @GetMapping
    public ResponseEntity listar() {
    	    	
    	List<Zona> lista = new ArrayList<Zona>();
    	
    	Zona z = new Zona();
    	z.setId(3L);
    	z.setNumero("223");;
    	lista.add(z);
    	
    	z = new Zona();
    	z.setId(4L);
    	z.setNumero("444");;
    	lista.add(z);
    	
    	z = new Zona();
    	z.setId(8L);
    	z.setNumero("987");;
    	lista.add(z);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity byId(@PathVariable int id) {    	  	
    	
    	Zona z = new Zona();
    	z.setId(1L);
    	z.setNumero("554");;
    
        return ResponseEntity.status(HttpStatus.OK).body(z);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@RequestBody Zona zona, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(zona);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
