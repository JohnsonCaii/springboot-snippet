package com.snippet.dao;

import com.snippet.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by caie on 07/11/2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
