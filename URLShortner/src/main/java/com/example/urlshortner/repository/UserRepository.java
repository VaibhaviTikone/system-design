package com.example.urlshortner.repository;

import com.example.urlshortner.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
