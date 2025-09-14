/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Labo;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public final class Stagiaire extends Personne{
    private String niveau;
    private String duree;
    private LocalDate datDeb;

    public Stagiaire(String niveau, String duree, String nom, String prénom, String mail, long tel,String acces,LocalDate datDeb) {
        super(nom, prénom, mail, tel,acces);
        this.niveau = niveau;
        this.duree = duree;
        this.datDeb=datDeb;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public LocalDate getDatDeb() {
        return datDeb;
    }

    public void setDatDeb(LocalDate datDeb) {
        this.datDeb = datDeb;
    }
    
    
    @Override
    public void afficher(){
        super.afficher();
        System.out.println("Niveau: "+this.niveau+", Duree: "+this.duree);
    }
}
