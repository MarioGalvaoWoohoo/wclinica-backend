package com.woohoo.wClinica.services;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woohoo.wClinica.models.AccessType;
import com.woohoo.wClinica.models.User;
import com.woohoo.wClinica.models.dto.UserCreateDTO;
import com.woohoo.wClinica.models.dto.UserUpdateDTO;
import com.woohoo.wClinica.repositories.AccessTypeRepository;


@Service
public class AccessTypeService {
    
    @Autowired //Tem a função de contrutor
    private AccessTypeRepository accessTypeRepository;

    public AccessType findById(Long id) {

        Optional<AccessType> accessType = this.accessTypeRepository.findById(id);

        // Por esta usando o Optional acima o tipo do retorno é diferente de User. Então Usamos o orElseThrow
        // Se existir o usuário é retornado, caso contrario uma exception
        return accessType.orElseThrow(() -> new RuntimeException(
            "Tipo de acesso não encontrado! Id: " + id + ", tipo: " + AccessType.class.getName()
        ));
    }

    // @Transactional // Essa anotação só permite a inserção caso de certo, caso contrario desfaz.
    // public User create(User obj) {
    //     //Por segurança informamos o id como null.
    //     obj.setId(null);

    //     obj = this.userRepository.save(obj);
    //     return obj;
    // }

    // @Transactional // Essa anotação só permite a inserção caso de certo, caso contrario desfaz.
    // public User update(User obj) {
    //     User newUser = findById(obj.getId());
    //     newUser.setPassword(obj.getPassword());
    //     newUser.setName(obj.getName());
    //     return this.userRepository.save(newUser);
    // }

    // @Transactional // Essa anotação só permite a inserção caso de certo, caso contrario desfaz.
    // public void delete(Long id) {
    //     findById(id);
    //     try {
    //         this.userRepository.deleteById(id);    
    //     } catch (Exception e) {
    //         throw new RuntimeException("Não é possivel excluir, pois há entidades relacionadas!");
    //     }
    // }

    // public User fromDTO(@Valid UserCreateDTO obj) {
    //     User user = new User();
    //     user.setLogin(obj.getLogin());
    //     user.setName(obj.getName());
    //     user.setPassword(obj.getPassword());
    //     user.setAccessTypeId(obj.getAccessTypeId());
    //     user.setEmail(obj.getEmail());
    //     user.setStatus(obj.getStatus());
    //     return user;
    // }

    // public User fromDTO(@Valid UserUpdateDTO obj) {
    //     User user = new User();
    //     user.setId(obj.getId());
    //     user.setName(obj.getName());
    //     user.setPassword(obj.getPassword());
    //     return user;
    // }
}
