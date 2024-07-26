package com.crio.stayease.services;

import com.crio.stayease.security.entity.Users;

import java.util.List;

public interface UserService {
    Users getUserById(Long id);
    List<Users> getUsers();
}
