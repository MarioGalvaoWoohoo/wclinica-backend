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

import com.woohoo.wClinica.models.Patient;
import com.woohoo.wClinica.models.dto.PatientDTO;
import com.woohoo.wClinica.services.PatientService;

@RestController
@RequestMapping("/api/patient")
@Validated
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping()
    public ResponseEntity<List<Patient>> getAll() {
        List<Patient> patient = this.patientService.getAll();

        return ResponseEntity.ok().body(patient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id ) {
        Patient patient = this.patientService.findById(id);

        return ResponseEntity.ok().body(patient);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody PatientDTO obj) {
        Patient patient = this.patientService.fromDTO(obj);
                
        Patient newPatient = this.patientService.create(patient);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newPatient.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@Valid @RequestBody PatientDTO obj, @PathVariable Long id) {
        obj.setId(id);
        Patient patient = this.patientService.fromDTO(obj);
        this.patientService.update(patient);
        Patient accessUpdated = this.patientService.findById(id);
        return ResponseEntity.ok().body(accessUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.patientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


