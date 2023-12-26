package com.umniki.JobPortal.Controller;

import com.umniki.JobPortal.Entity.User;
import com.umniki.JobPortal.Service.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @GetMapping("/find-by-id/{id}")
    public User findById(@PathVariable String id){
        return userService.findById(id);
    }

    @GetMapping("/list-all")
    public List<User> listAllUser(){
        return userService.listAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteById(id);
    }

    @GetMapping("/get-user")
    public User getCurrentUser(){
        return userService.getCurrentUser();
    }


}
