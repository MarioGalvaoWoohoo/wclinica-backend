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


import com.woohoo.wClinica.models.Doctor;
import com.woohoo.wClinica.models.dto.DoctorDTO;
import com.woohoo.wClinica.services.DoctorService;

@RestController
@RequestMapping("/api/doctor")
@Validated
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping()
    public ResponseEntity<List<Doctor>> getAll() {
        List<Doctor> doctor = this.doctorService.getAll();

        return ResponseEntity.ok().body(doctor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable Long id ) {
        Doctor doctor = this.doctorService.findById(id);

        return ResponseEntity.ok().body(doctor);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody DoctorDTO obj) {
        Doctor doctor = this.doctorService.fromDTO(obj);
                
        Doctor newDoctor = this.doctorService.create(doctor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newDoctor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> update(@Valid @RequestBody DoctorDTO obj, @PathVariable Long id) {
        obj.setId(id);
        Doctor doctor = this.doctorService.fromDTO(obj);
        this.doctorService.update(doctor);
        Doctor accessUpdated = this.doctorService.findById(id);
        return ResponseEntity.ok().body(accessUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


