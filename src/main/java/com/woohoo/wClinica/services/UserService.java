package com.woohoo.wClinica.services;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woohoo.wClinica.models.User;
import com.woohoo.wClinica.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired //Tem a função de contrutor
    private UserRepository userRepository;

    public User findById(Long id) {

        Optional<User> user = this.userRepository.findById(id);

        // Por esta usando o Optional acima o tipo do retorno é diferente de User. Então Usamos o orElseThrow
        // Se existir o usuário é retornado, caso contrario uma exception
        return user.orElseThrow(() -> new RuntimeException(
            "Usuário não encontrado! Id: " + id + ", tipo: " + User.class.getName()
        ));
    }

    @Transactional // Essa anotação só permite a inserção caso de certo, caso contrario desfaz.
    public User create(User obj) {
        //Por segurança informamos o id como null.
        obj.setId(null);

        obj = this.userRepository.save(obj);
        return obj;
    }

    @Transactional // Essa anotação só permite a inserção caso de certo, caso contrario desfaz.
    public User update(User obj) {
        User newUser = findById(obj.getId());
        newUser.setPassword(obj.getPassword());
        return this.userRepository.save(newUser);
    }

    
    public void delete(Long id) {
        findById(id);
        try {
            this.userRepository.deleteById(id);    
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir, pois há entidades relacionadas!");
        }
        
    }

}