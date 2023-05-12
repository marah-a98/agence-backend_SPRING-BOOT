package com.example.agence.model;



import javax.persistence.*;


@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long id;

    private String chekin;

    private  String chekout;

    private String personne;

   private  String typeron;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private  Client client;

   @ManyToOne
   @JoinColumn(name = "id_hotel")
   private  Hotel hotel;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChekin() {
        return chekin;
    }

    public void setChekin(String chekin) {
        this.chekin = chekin;
    }

    public String getChekout() {
        return chekout;
    }

    public void setChekout(String chekout) {
        this.chekout = chekout;
    }

    public String getPersonne() {
        return personne;
    }

    public void setPersonne(String personne) {
        this.personne = personne;
    }

    public String getTyperon() {
        return typeron;
    }

    public void setTyperon(String typeron) {
        this.typeron = typeron;
    }
}
