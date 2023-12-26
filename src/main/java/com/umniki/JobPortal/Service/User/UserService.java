package com.umniki.JobPortal.Service.User;

import com.umniki.JobPortal.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();

    List<User> listAll();
    User findById(String id);
    void deleteById(String id);
    User getCurrentUser();

    User save(User user);
}
