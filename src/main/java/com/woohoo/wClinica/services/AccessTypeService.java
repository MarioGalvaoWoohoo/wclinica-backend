package com.woohoo.wClinica.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woohoo.wClinica.models.AccessType;
import com.woohoo.wClinica.models.dto.AccessTypeDTO;
import com.woohoo.wClinica.repositories.AccessTypeRepository;


@Service
public class AccessTypeService {
    
    @Autowired //Tem a função de contrutor
    private AccessTypeRepository accessTypeRepository;

    public List<AccessType> getAll() {
        return this.accessTypeRepository.findAll();
    }

    public AccessType findById(Long id) {
        Optional<AccessType> accessType = this.accessTypeRepository.findById(id);

        // Por esta usando o Optional acima o tipo do retorno é diferente de User. Então Usamos o orElseThrow
        // Se existir o usuário é retornado, caso contrario uma exception
        return accessType.orElseThrow(() -> new RuntimeException(
            "Tipo de acesso não encontrado! Id: " + id + ", tipo: " + AccessType.class.getName()
        ));
    }

    @Transactional // Essa anotação só permite a inserção caso de certo, caso contrario desfaz.
    public AccessType create(AccessType obj) {
        obj = this.accessTypeRepository.save(obj);
        return obj;
    }

    @Transactional // Essa anotação só permite a inserção caso de certo, caso contrario desfaz.
    public AccessType update(AccessType obj) {
        AccessType newAccess = findById(obj.getId());
        newAccess.setAccessName(obj.getAccessName());
        return this.accessTypeRepository.save(newAccess);
    }

    @Transactional // Essa anotação só permite a inserção caso de certo, caso contrario desfaz.
    public void delete(Long id) {
        findById(id);
        try {
            this.accessTypeRepository.deleteById(id);    
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir, pois há entidades relacionadas!");
        }
    }

    public AccessType fromDTO(@Valid AccessTypeDTO obj) {
        AccessType accessType = new AccessType();
        accessType.setId(obj.getId());
        accessType.setAccessName(obj.getAccessName());
        return accessType;   
    }
    
}
