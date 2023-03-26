package com.woohoo.wClinica.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woohoo.wClinica.models.Patient;
import com.woohoo.wClinica.models.dto.PatientDTO;
import com.woohoo.wClinica.repositories.PatientRepository;



@Service
public class PatientService {
    
    @Autowired //Tem a função de contrutor
    private PatientRepository patientRepository;

    public List<Patient> getAll() {
        return this.patientRepository.findAll();
    }

    public Patient findById(Long id) {
        Optional<Patient> patient = this.patientRepository.findById(id);

        // Por esta usando o Optional acima o tipo do retorno é diferente de User. Então Usamos o orElseThrow
        // Se existir o usuário é retornado, caso contrario uma exception
        return patient.orElseThrow(() -> new RuntimeException(
            "Paciente não encontrado! Id: " + id + ", tipo: " + Patient.class.getName()
        ));
    }

    @Transactional
    public Patient create(Patient obj) {
        obj = this.patientRepository.save(obj);
        return obj;
    }

    @Transactional
    public Patient update(Patient obj) {
        Patient newPatient = findById(obj.getId());
        newPatient.setName(obj.getName());
        return this.patientRepository.save(newPatient);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        try {
            this.patientRepository.deleteById(id);    
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir, pois há entidades relacionadas!");
        }
    }

    public Patient fromDTO(@Valid PatientDTO obj) {
        Patient patient = new Patient();
        patient.setId(obj.getId());
        patient.setName(obj.getName());
        patient.setDocument(obj.getDocument());
        patient.setDateOfBirth(obj.getDateOfBirth());
        patient.setTypeDocument(obj.getTypeDocument());
        patient.setAddress(obj.getAddress());
        patient.setCity(obj.getCity());
        patient.setState(obj.getState());
        return patient;   
    }
    
}
