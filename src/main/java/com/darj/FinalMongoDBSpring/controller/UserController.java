package com.darj.FinalMongoDBSpring.controller;

import com.darj.FinalMongoDBSpring.dto.UserDto;
import com.darj.FinalMongoDBSpring.exceptions.UserNotFoundException;
import com.darj.FinalMongoDBSpring.model.User;
import com.darj.FinalMongoDBSpring.service.UsersServiceMongoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users/")
public class UserController {

    private final UsersServiceMongoDb usersService;

    public UserController(@Autowired UsersServiceMongoDb usersService) {
        this.usersService = usersService;
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createUser = usersService.save(user);
        URI createdUserUri = URI.create("/v1/users/" + createUser.getId());
        return ResponseEntity.created(createdUserUri).body(createUser);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = usersService.all();
        return ResponseEntity.ok(users);
    }
    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        User user = usersService.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
        return  ResponseEntity.ok(user);

    }
    @PutMapping ("{id}")
    public ResponseEntity<User> updateUser(@PathVariable ("id")String id, @RequestBody
    UserDto userDto){
        try{
            Optional<User> optionalUser = usersService.findById(id);
            if(optionalUser.isPresent()){
                User existingUser = optionalUser.get();
                existingUser.setName(userDto.getName());
                existingUser.setLastName(userDto.getLastName());
                usersService.save(existingUser);
                return ResponseEntity.ok(existingUser);
            }else{
                throw new UserNotFoundException(id);
            }
        } catch (UserNotFoundException e) {
            throw e;
        }catch (Exception e){
            throw new UserNotFoundException(id);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ("id") String id ){
        Optional<User> optionalUser = usersService.findById(id);
        if (optionalUser.isEmpty()){
            throw new UserNotFoundException(id);

        }
        usersService.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }
}

