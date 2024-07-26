package com.crio.stayease.services.implementation;

import com.crio.stayease.security.entity.Users;
import com.crio.stayease.security.repository.UserRepository;
import com.crio.stayease.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public Users getUserById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
    }

    @Override
    public List<Users> getUsers() {
        return repository.findAll();
    }
}
