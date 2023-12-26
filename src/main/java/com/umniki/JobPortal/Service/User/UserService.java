package com.umniki.JobPortal.Service.User;

import com.umniki.JobPortal.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDetailsService userDetailsService();

    List<User> listAll();
    User findById(String id);
    void deleteById(String id);
    User getCurrentUser();

    Optional<User> findUserByEmail(String email);

    User save(User user);
}
