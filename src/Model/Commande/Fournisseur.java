/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Commande;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Extreme PC
 */
public class Fournisseur {
 
    private String nom;
    private String telephone;
    private List<String> materielsDisponibles = new ArrayList<>();

    // Constructor
    public Fournisseur(String nom, String telephone) {
        this.nom = nom;
        this.telephone = telephone;
    }

    // Method prototypes and their purposes:

    // 1. Add a material
    public void ajouterMateriel(String nomMateriel) {
        if (!materielsDisponibles.contains(nomMateriel)) {
            materielsDisponibles.add(nomMateriel);
            System.out.println(nomMateriel + " a été ajouté.");
        } else {
            System.out.println(nomMateriel + " est déjà dans la liste.");
        }
    }
    public boolean estDisponible(String materiel1){
         if(materielsDisponibles.contains(materiel1)==false){
             return false;}
         else{ 
               return true;
              }
         }
    

    // 2. Remove a material
    public void retirerMateriel(String nomMateriel) {
        if (materielsDisponibles.remove(nomMateriel)) {
            System.out.println(nomMateriel + " a été retiré.");
        } else {
            System.out.println(nomMateriel + " n'existe pas dans la liste.");
        }
    }

    // 3. Display all available materials
    public void afficherMaterielsDisponibles() {
        System.out.println("Matériaux disponibles:");
        for (String materiel : materielsDisponibles) {
            System.out.println("Matériel: " + materiel);
        }
    }
   
    // Accessor methods for nom and telephone
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

    

