package com.crio.xlido.commands;

import java.util.List;
import com.crio.xlido.entities.User;
import com.crio.xlido.services.UserService;

public class CreateUserCommand implements ICommand{
    private final UserService userService;

    public CreateUserCommand(UserService userService){
        this.userService = userService;
    }


    @Override
    public void invoke(List<String> tokens) {
        String email = tokens.get(1);
        String password = tokens.get(2);
        User user = userService.createUser(email,password);
        System.out.println(user);
    }
    
}
