package com.example.agence.repository;

import com.example.agence.model.Agent;
import com.example.agence.model.User;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1 and u.password = ?2")
    User findUserByEmailAndFirstname(String email , String password);

}
