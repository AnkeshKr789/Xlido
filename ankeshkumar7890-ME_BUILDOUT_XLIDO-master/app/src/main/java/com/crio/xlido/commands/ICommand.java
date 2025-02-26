package com.crio.xlido.commands;

import java.util.List;

public interface ICommand{
    void invoke(List<String> tokens);
}