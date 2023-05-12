package com.example.agence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nom;

    private String contry;

    private String city;

    private Long nombretoile;

    private String image;



    @OneToMany(mappedBy = "hotel")
    private List<Reservation> reservations;

    @JsonIgnore
    public List<Reservation> getReservations() {
        return reservations;
    }
//place nbre d'etoile

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getNombretoile() {
        return nombretoile;
    }

    public void setNombretoile(Long nombretoile) {
        this.nombretoile = nombretoile;
    }


    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
