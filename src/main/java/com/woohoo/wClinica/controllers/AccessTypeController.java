package com.woohoo.wClinica.controllers;

import java.net.URI;
import java.util.List;
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
import com.woohoo.wClinica.models.dto.AccessTypeDTO;
import com.woohoo.wClinica.models.dto.UserCreateDTO;
import com.woohoo.wClinica.models.dto.UserUpdateDTO;
import com.woohoo.wClinica.repositories.AccessTypeRepository;
import com.woohoo.wClinica.services.AccessTypeService;
import com.woohoo.wClinica.services.UserService;

@RestController
@RequestMapping("/api/accessType")
@Validated
public class AccessTypeController {

    @Autowired
    private AccessTypeService accessTypeService;

    @GetMapping()
    public ResponseEntity<List<AccessType>> getAll() {
        List<AccessType> accessType = this.accessTypeService.getAll();

        return ResponseEntity.ok().body(accessType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessType> findById(@PathVariable Long id ) {
        AccessType accessType = this.accessTypeService.findById(id);

        return ResponseEntity.ok().body(accessType);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody AccessTypeDTO obj) {
        AccessType accessType = this.accessTypeService.fromDTO(obj);
                
        AccessType newAccessType = this.accessTypeService.create(accessType);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newAccessType.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccessType> update(@Valid @RequestBody AccessTypeDTO obj, @PathVariable Long id) {
        obj.setId(id);
        AccessType accessType = this.accessTypeService.fromDTO(obj);
        this.accessTypeService.update(accessType);
        AccessType accessUpdated = this.accessTypeService.findById(id);
        return ResponseEntity.ok().body(accessUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.accessTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


