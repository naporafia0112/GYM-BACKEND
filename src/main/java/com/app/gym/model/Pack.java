package com.app.gym.model;

import jakarta.persistence.*;

@Entity
@Table(name = "packs")
public class Pack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nomOffre;

    private int dureeOffre;

    private double prixMensuel;

    // Constructeurs
    public Pack() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomOffre() { return nomOffre; }
    public void setNomOffre(String nomOffre) { this.nomOffre = nomOffre; }

    public int getDureeOffre() { return dureeOffre; }
    public void setDureeOffre(int dureeOffre) { this.dureeOffre = dureeOffre; }

    public double getPrixMensuel() { return prixMensuel; }
    public void setPrixMensuel(double prixMensuel) { this.prixMensuel = prixMensuel; }
}