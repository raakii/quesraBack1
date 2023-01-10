package com.quesra.quesra.service;

import com.quesra.quesra.domain.User;
import com.quesra.quesra.dto.ConnectDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(long id);
    User updateUser(long id, User user);
    User connectUser(ConnectDto user);

    void delete(long id);

    User findByEmail(String email);

}
