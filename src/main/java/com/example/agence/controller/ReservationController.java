package com.example.agence.controller;

import com.example.agence.model.Client;
import com.example.agence.model.Hotel;
import com.example.agence.model.Reservation;
import com.example.agence.repository.ClientRepository;
import com.example.agence.repository.HotelRepository;
import com.example.agence.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ReservationController {

    @Autowired
     private ReservationRepository reservationRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/resrevation")
    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }

    @PostMapping("/reservation/{id_client}/{id_hotel}")
     public Reservation save(@RequestBody Reservation reservation, @PathVariable Long id_client , @PathVariable Long id_hotel){

        Client c = clientRepository.findById(id_client).orElse(null);
        reservation.setClient(c);
        Hotel h = hotelRepository.findById(id_hotel).orElse(null);
        reservation.setHotel(h);

        return reservationRepository.save(reservation);
    }


}
