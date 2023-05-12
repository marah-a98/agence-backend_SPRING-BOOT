package com.example.agence.repository;

import com.example.agence.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
//    @Query("SELECT u FROM Client u WHERE u.nom=?1 ")
//    List<Client> findByNom(@PathVariable String nom );
//    @Query("SELECT u From Client u WHERE u.prenom=?1")
//    List<Client> findByPrenom(@PathVariable String prenom);
//    @Query("SELECT u FROM Client u WHERE u.age=?1")
//    List<Client> findByAge(Double age );
}
