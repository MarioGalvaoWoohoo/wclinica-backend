package com.woohoo.wClinica.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woohoo.wClinica.models.Doctor;
import com.woohoo.wClinica.models.dto.DoctorDTO;
import com.woohoo.wClinica.repositories.DoctorRepository;



@Service
public class DoctorService {
    
    @Autowired //Tem a função de contrutor
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll() {
        return this.doctorRepository.findAll();
    }

    public Doctor findById(Long id) {
        Optional<Doctor> doctor = this.doctorRepository.findById(id);

        // Por esta usando o Optional acima o tipo do retorno é diferente de User. Então Usamos o orElseThrow
        // Se existir o usuário é retornado, caso contrario uma exception
        return doctor.orElseThrow(() -> new RuntimeException(
            "Médico não encontrado! Id: " + id + ", tipo: " + Doctor.class.getName()
        ));
    }

    @Transactional
    public Doctor create(Doctor obj) {
        obj = this.doctorRepository.save(obj);
        return obj;
    }

    @Transactional
    public Doctor update(Doctor obj) {
        Doctor newDoctor = findById(obj.getId());
        newDoctor.setName(obj.getName());
        return this.doctorRepository.save(newDoctor);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        try {
            this.doctorRepository.deleteById(id);    
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir, pois há entidades relacionadas!");
        }
    }

    public Doctor fromDTO(@Valid DoctorDTO obj) {
        Doctor doctor = new Doctor();
        doctor.setId(obj.getId());
        doctor.setName(obj.getName());
        doctor.setCrm(obj.getCrm());
        doctor.setDocument(obj.getDocument());
        doctor.setTypeDocument(obj.getTypeDocument());
        doctor.setSpecialty(obj.getSpecialty());
        return doctor;   
    }
    
}
