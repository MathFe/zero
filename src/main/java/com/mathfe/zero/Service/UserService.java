package com.mathfe.zero.Service;


import com.mathfe.zero.Entity.User;
import com.mathfe.zero.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User findUser(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not find with id: " + id));
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User updatedUser) {
        Optional<User> existentUser = userRepository.findById(id);
        if(existentUser.isPresent()){
            User user = existentUser.get();
            user.setName(existentUser.get().getName());
            user.setEmail(existentUser.get().getEmail());
            return userRepository.save(user);
        }
        throw new RuntimeException("User not find.");
    }
}
