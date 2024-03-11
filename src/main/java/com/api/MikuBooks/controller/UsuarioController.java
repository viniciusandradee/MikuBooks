package com.api.MikuBooks.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.MikuBooks.model.Usuario;
import com.api.MikuBooks.repository.UsuarioRepository;


@Controller
@RestController
@RequestMapping("usuario")
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired // CDI // TO DO explicar
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> index() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) {
        log.info("cadastrando usuario: {}", usuario);
        usuarioRepository.save(usuario);
        return usuario;
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> get(@PathVariable Long id) {
        log.info("Buscar por id: {}", id);

        return usuarioRepository
                    .findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object>destroy(@PathVariable Long id){
        log.info("Apagando usuario{}", id);

        verificarSeExisteUsuario(id);

        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Usuario usuario){

        log.info("Atualizando a usuario id{} para {}", id, usuario);

        verificarSeExisteUsuario(id);

        usuario.setId(id);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    private void verificarSeExisteUsuario(long id) {
        usuarioRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado")
            );
    }
}