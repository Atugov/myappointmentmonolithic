package com.services.myappointmentmonolithtic.service;

import com.services.myappointmentmonolithtic.model.User;
import com.services.myappointmentmonolithtic.repository.JPAUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final JPAUserRepository userRepository;

    private User currentUser;


    public UserService(JPAUserRepository userRepository) {
        this.userRepository = userRepository;

    }



    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String login) {
       currentUser = userRepository.findUserByLogin(login);
    }
}
