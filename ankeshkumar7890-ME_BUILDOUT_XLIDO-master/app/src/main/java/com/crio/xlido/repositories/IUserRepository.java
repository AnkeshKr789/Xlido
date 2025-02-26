package com.crio.xlido.repositories;

import com.crio.xlido.entities.User;

public interface IUserRepository {
    User save(String email, String password);
    boolean userExist(int id);
}
