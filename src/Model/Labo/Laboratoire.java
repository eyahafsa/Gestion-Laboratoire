/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Labo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author DELL
 */
public class Laboratoire {
   private String nom;
   private String adresse;
   private long numero;
   private ObservableList<Personne> listPersonnel;

    public ObservableList<Personne> getListPers() {
        return listPersonnel;
    }

    public void setListPers(ObservableList<Personne> listPers) {
        this.listPersonnel = listPers;
    }

    public Laboratoire(String nom, String adresse, long numero) {
        this.nom = nom;
        this.adresse = adresse;
        this.numero = numero;
        listPersonnel= FXCollections.observableArrayList();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
    
    public void ajouterPersonnel(Personne p){
        if (p instanceof Stagiaire) {
            Stagiaire stagiaire = (Stagiaire) p; // Instancier comme stagiaire
            System.out.println("Ajout d'un stagiaire : " + stagiaire.getNom());
            listPersonnel.add(stagiaire);
        }  else if (p instanceof Personnel) {
            Personnel personnel = (Personnel) p; // Instancier comme personnel
            System.out.println("Ajout d'un personnel : " + personnel.getNom());
            listPersonnel.add(personnel);
        } else {
            System.out.println("Type personnel inconnu. Ajout impossible.");
        }
    }
    
    public void affichageLabo(){
        System.out.println("Nom: "+this.nom+", Adresse: "+this.adresse+", Numero: "+this.numero+"\n");
        Stream <Personne> sp=listPersonnel.stream();
        System.out.println("Liste du personnel: ");
        sp.forEach(p->p.afficher());
    }
}
