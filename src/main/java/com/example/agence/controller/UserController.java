package com.example.agence.controller;

import com.example.agence.model.User;
import com.example.agence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/usersend")
     public void Send() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("amdounia16@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

        System.out.println("email done");
    }




    @GetMapping("/user")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @PostMapping("/user/byemailfirstname")
    public User findUserByEmailAndFirstname(@RequestBody User user ){
        return  userRepository.findUserByEmailAndFirstname(user.getEmail() , user.getPassword());}

}
