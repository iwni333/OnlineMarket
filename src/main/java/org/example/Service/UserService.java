package org.example.Service;

import org.example.DAO.UserRepository;
import org.example.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
