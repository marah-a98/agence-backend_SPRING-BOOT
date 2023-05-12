package com.example.agence.controller;

import com.example.agence.model.Billet;
import com.example.agence.repository.BilletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BilletController {
    @Autowired
    private BilletRepository billetRepository;

    @GetMapping("/billet")
    public List<Billet> findAll(){
        return billetRepository.findAll();
    }
    @GetMapping("/billet/id/{id}")
    public Billet findById(@PathVariable Long id){
        return billetRepository.findById(id).orElse(null);
    }
    @PostMapping("/billet/save")
    public Billet save(@RequestBody Billet billet){
        return billetRepository.save(billet);
    }
    @PutMapping("/billet/{id}")
    public Billet update(@PathVariable Long id , @RequestBody Billet billet){
        billet.setId(id);
        Billet oldBillet=billetRepository.findById(id).orElse(null);
        billet.setCheckin(billet.getCheckin()==null?oldBillet.getCheckin():billet.getCheckin());
        billet.setCheckout(billet.getCheckout()==null?oldBillet.getCheckout():billet.getCheckout());
        billet.setAdult(billet.getAdult()==null?oldBillet.getAdult():billet.getAdult());
        billet.setChildren(billet.getChildren()==null?oldBillet.getChildren():billet.getChildren());
        billet.setRoom(billet.getRoom()==null?oldBillet.getRoom():billet.getRoom());
        billet.setDestination(billet.getDestination()==null?oldBillet.getDestination():billet.getDestination());
        return billetRepository.save(billet);
    }

    @DeleteMapping("/billet/{id}")
    public void delete(@PathVariable Long id ){
        billetRepository.deleteById(id);
    }
}
