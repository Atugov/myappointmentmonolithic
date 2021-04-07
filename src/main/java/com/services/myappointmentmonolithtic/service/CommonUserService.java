package com.services.myappointmentmonolithtic.service;

import com.services.myappointmentmonolithtic.model.User;
import com.services.myappointmentmonolithtic.repository.JPAUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonUserService {
    private final JPAUserRepository userRepository;


    public CommonUserService(JPAUserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.getOne(id);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
