package com.aula.restapi;

import java.util.List;

import com.aula.restapi.database.RepositorioContato;
import com.aula.restapi.exercicio.Contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 @RestController
 @RequestMapping("/contato")
public class ContatoREST {
    @Autowired
    private RepositorioContato repositorio;

    @GetMapping 
    public List<Contato>listar(){
        return repositorio.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody Contato contato){
        repositorio.save(contato);
        }

     @PutMapping
    public void alterar(Contato contato) {
        if(contato.getId()>0)
        repositorio.save(contato);
    }

    @DeleteMapping
    public void excluir (RequestBody Contato contato){
        repositorio.delete(contato);
    }

}



