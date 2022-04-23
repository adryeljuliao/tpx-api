package com.tpxsports.tpxsports.services;

import com.tpxsports.tpxsports.domains.User;
import com.tpxsports.tpxsports.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        List<User> listUser = userRepository.findAll();
        listUser.forEach(user -> {
            calcKD(user);
        });
        return listUser;
    }

    public User findStatsUser(Integer id) {
        var user = userRepository.findById(id).orElse(null);

        calcKD(user);

        return user;
    }

    private void calcKD(User user) {
        if (Objects.nonNull(user)) {
            Double kd = (double) user.getKills() / (double) user.getDeaths();
            user.setKd(kd);
        }
    }

}
