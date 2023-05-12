package com.example.agence.repository;

import com.example.agence.model.Billet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface BilletRepository extends JpaRepository<Billet,Long> {
//    @Query("SELECT u FROM Billet u WHERE u.datereservation=?1")
//    List<Billet> findByDatereservation(@PathVariable String datereservation);
//    @Query("SELECT u FROM Billet u WHERE u.destination=?1")
//    List<Billet> findByDestination(@PathVariable String distination);

}
