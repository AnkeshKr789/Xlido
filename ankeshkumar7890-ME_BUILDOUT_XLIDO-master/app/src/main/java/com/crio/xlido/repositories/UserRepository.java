package com.crio.xlido.repositories;

import java.util.HashMap;
import java.util.Map;
import com.crio.xlido.entities.User;

public class UserRepository implements IUserRepository {
    private Map<Integer, User> users = new HashMap<>();

    private int idCounter = 1;
    @Override
    public User save(String email, String password) {
        User user = new User(idCounter, email, password);
        users.put(idCounter, user);
        idCounter++;
        return user;
    }

    @Override
    public boolean userExist(int id) {
        return users.containsKey(id);
    }
}
