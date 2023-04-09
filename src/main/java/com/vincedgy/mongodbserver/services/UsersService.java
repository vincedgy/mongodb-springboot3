package com.vincedgy.mongodbserver.services;

import com.vincedgy.mongodbserver.UsersRepository;
import com.vincedgy.mongodbserver.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public List<User> getAllUsersByName(String name) {
        return usersRepository.findUserByLastName(name);
    }

    public User save(User user) {
        return usersRepository.save(user);

    }

    public Optional<User> getUserById(String id) {
        return usersRepository.findById(id);
    }

    public void delete(String id) {
        usersRepository.deleteById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return usersRepository.findUserByEmail(email);
    }
}
