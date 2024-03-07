package com.api.MikuBooks.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.MikuBooks.model.Usuario;


@Controller
@RestController
@RequestMapping("usuario")
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(getClass());
    List<Usuario> repository = new ArrayList<>();

    @GetMapping
    public List<Usuario> index() {
        return repository;
    }

    @PostMapping
    // @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        log.info("cadastrando usuario: {}", usuario);
        repository.add(usuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuario);
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> get(@PathVariable Long id) {
        log.info("Buscar por id: {}", id);

        var optionalUsuario = buscarUsuarioPorId(id);

        if (optionalUsuario.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(optionalUsuario.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object>destroy(@PathVariable Long id){
        log.info("Apagando usuario{}", id);

        var optionalUsuario = buscarUsuarioPorId(id);

        if(optionalUsuario.isEmpty())
            return ResponseEntity.notFound().build();


        repository.remove(optionalUsuario.get());

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Usuario usuario){

        log.info("Atualizando a usuario id{} para {}", id, usuario);

        var optionalUsuario = buscarUsuarioPorId(id);

        if(optionalUsuario.isEmpty())
            return ResponseEntity.notFound().build();
        
        var usuarioEncontrada = optionalUsuario.get();
        var usuarioAtualizada = new Usuario(id, usuario.username(), usuario.email(), usuario.password(),usuario.telefone(), usuario.dataNascimento());
        repository.remove(usuarioEncontrada);
        repository.add(usuarioAtualizada);

        return ResponseEntity.ok().body(usuarioAtualizada);

    }
    
    private Optional<Usuario> buscarUsuarioPorId(Long id) {
        var optionalUsuario = repository
                .stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
        return optionalUsuario;
    }

}