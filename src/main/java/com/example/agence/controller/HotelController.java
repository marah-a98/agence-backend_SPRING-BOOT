package com.example.agence.controller;

import com.example.agence.model.Hotel;
import com.example.agence.repository.HotelRepository;
import com.example.agence.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.GeneratedValue;
import java.awt.*;
import java.util.List;

@RestController
@CrossOrigin("*")

public class HotelController {
    @Autowired
    public HotelRepository hotelRepository;

    @Autowired
    public StorageService storage;

    @GetMapping("/hotel")
        public List<Hotel> findAll(){
        return  hotelRepository.findAll();
    }

    @GetMapping("hotel/id/{id}")
    public Hotel findById(@PathVariable Long id){
        return hotelRepository.findById(id).orElse(null);
    }




    @PostMapping("hotel/save")
    public Hotel save(@RequestParam MultipartFile file , Hotel hotel ){

        String fileName = storage.CreateNameImage(file);
        storage.store(file,fileName);
        hotel.setImage(fileName);
        return hotelRepository.save(hotel);
    }

    @PutMapping("hotel/{id}")
    public  Hotel update(@PathVariable Long id , @RequestBody Hotel hotel){
        hotel.setId(id);
        Hotel oldhotel=hotelRepository.findById(id).orElse(null);
        hotel.setNom(hotel.getNom()==null?oldhotel.getNom():hotel.getNom());
        hotel.setContry(hotel.getContry()==null?oldhotel.getContry():hotel.getContry());
        hotel.setCity(hotel.getCity()==null?oldhotel.getCity():hotel.getCity());
        hotel.setNombretoile(hotel.getNombretoile()==null?oldhotel.getNombretoile():hotel.getNombretoile());

        return  hotelRepository.save(hotel);
    }

    @DeleteMapping("/hoteldelete/{id}")
    public void delete(@PathVariable Long id ){
        hotelRepository.deleteById(id);
    }


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storage.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
