package com.darj.FinalMongoDBSpring.service;

import com.darj.FinalMongoDBSpring.model.User;
import com.darj.FinalMongoDBSpring.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceMongoDb implements UsersService {

    private final UserMongoRepository userMongoRepository;

    @Autowired
    public UsersServiceMongoDb(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public User save(User user) {
        //String idUser = user.getId();
        return userMongoRepository.save(user);
    }

    @Override
    public Optional<User> findById(String id) {
        //User user = userMongoRepository.findById(id).get();
        return userMongoRepository.findById(id);
    }
    @Override
    public List<User> all() {
        List<User> userList = userMongoRepository.findAll();
        return userList;
    }
    @Override
    public void deleteById(String id) {
        Optional<User> optionalUser = userMongoRepository.findById(id);
        if (optionalUser.isEmpty()){
        }
        userMongoRepository.deleteById(id);
    }
    @Override
    public User update(User user, String userId) {
        if (!user.getId().equals(userId)){
            throw new IllegalArgumentException("User Id " + userId);
        }
        User updateUser = userMongoRepository.save(user);
        return userMongoRepository.save(user);
    }

}