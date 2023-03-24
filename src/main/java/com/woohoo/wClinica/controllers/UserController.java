package com.woohoo.wClinica.controllers;

import java.net.URI;
import java.util.Optional;

import javax.sound.midi.VoiceStatus;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.woohoo.wClinica.models.AccessType;
import com.woohoo.wClinica.models.User;
import com.woohoo.wClinica.models.dto.UserCreateDTO;
import com.woohoo.wClinica.models.dto.UserUpdateDTO;
import com.woohoo.wClinica.repositories.AccessTypeRepository;
import com.woohoo.wClinica.services.AccessTypeService;
import com.woohoo.wClinica.services.UserService;

@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {
    
    @Autowired //Injeção de dependencia
    private UserService userService;

    @Autowired //Injeção de dependencia
    private AccessTypeService accessTypeService;

    @Autowired //Injeção de dependencia
    private AccessTypeRepository accessTypeRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id ) {
        User user = this.userService.findById(id);

        return ResponseEntity.ok().body(user);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody UserCreateDTO obj) {
        User user = this.userService.fromDTO(obj);
                
        User newUser = this.userService.create(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@Valid @RequestBody UserUpdateDTO obj, @PathVariable Long id) {
        obj.setId(id);
        User user = this.userService.fromDTO(obj);
        this.userService.update(user);
        User userUpdated = this.userService.findById(id);
        return ResponseEntity.ok().body(userUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


