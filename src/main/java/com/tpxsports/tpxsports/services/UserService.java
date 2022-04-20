package com.tpxsports.tpxsports.services;

import com.tpxsports.tpxsports.domains.User;
import com.tpxsports.tpxsports.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findStatsUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

}
