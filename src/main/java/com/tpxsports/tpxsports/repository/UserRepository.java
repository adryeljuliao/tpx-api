package com.tpxsports.tpxsports.repository;

import com.tpxsports.tpxsports.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
