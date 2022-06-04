package com.tpxsports.tpxsports.services;

import com.tpxsports.tpxsports.domains.User;
import com.tpxsports.tpxsports.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

            BigDecimal kills = BigDecimal.valueOf(user.getKills());
            BigDecimal deaths = BigDecimal.valueOf(user.getDeaths());

            if (deaths.equals(BigDecimal.ZERO) || kills.equals(BigDecimal.ZERO)) {
                user.setKd(kills);
            } else {
                user.setKd(kills.divide(deaths, 2, RoundingMode.HALF_EVEN));
            }
        }
    }

}
