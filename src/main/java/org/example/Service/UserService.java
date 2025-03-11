package org.example.Service;

import org.example.Models.Product;
import org.example.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void save(User user) {
        user.setRole(User.Role.USER);
        userRepository.save(user);
    }



}
