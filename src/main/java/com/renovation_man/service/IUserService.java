package com.renovation_man.service;

import java.util.List;

public interface IUserService<U> {
    public List<U> findAll();
    
    public U save(final U user);
    
    public U findById(Integer id);
}
