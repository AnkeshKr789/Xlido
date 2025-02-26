package com.crio.xlido.services;

import com.crio.xlido.entities.User;
import com.crio.xlido.repositories.IUserRepository;

public class UserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(String email, String password){
        return userRepository.save(email, password);
    }

    public boolean userExist(int organizerId) {
        return userRepository.userExist(organizerId);
    }
    
}
