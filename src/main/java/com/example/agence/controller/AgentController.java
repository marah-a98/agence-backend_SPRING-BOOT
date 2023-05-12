package com.example.agence.controller;

import com.example.agence.model.Agent;
import com.example.agence.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@RestController
@CrossOrigin("*")
public class AgentController {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private AgentRepository agentRepository;

    @GetMapping("/agent")
    public List<Agent> findAll(){
        return agentRepository.findAll();
    }

    @GetMapping("/agent/{id}")
    public Agent getById(@PathVariable Long id ){
        return  agentRepository.findById(id).orElse(null);
    }

    @PostMapping("/agent/save")
    public Agent save(@RequestBody Agent agent){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(agent.getEmail());

        msg.setSubject("Agent regiter with succes ");
        msg.setText("Hello \n" + agent.getFirstname()+" " + agent.getLastname()+ "\n you have to singin now ");

        javaMailSender.send(msg);

        System.out.println("email done");
        return agentRepository.save(agent);
    }
    @PutMapping("/agent/{id}")
    public Agent update(@PathVariable Long id , @RequestBody Agent agent){
        agent.setId(id);
        Agent oldagent=agentRepository.findById(id).orElse(null);
        agent.setFirstname(agent.getFirstname()==null?oldagent.getFirstname():agent.getFirstname());
        agent.setLastname(agent.getLastname()==null?oldagent.getLastname():agent.getLastname());
        agent.setEmail(agent.getEmail()==null?oldagent.getEmail():agent.getEmail());
        agent.setMobile(agent.getMobile()==null?oldagent.getMobile():agent.getMobile());
        agent.setPassword(agent.getPassword()==null?oldagent.getPassword():agent.getPassword());
        return agentRepository.save(agent);
        }

    @DeleteMapping("/agent/{id}")
    public void delete(@PathVariable Long id){
        agentRepository.deleteById(id);
    }



}