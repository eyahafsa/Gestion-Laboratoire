/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Technique;

/**
 *
 * @author ayach
 */
public class Technicien {
   private String nom;
    private String prenom;
    private String specialite;

    public Technicien(String nom, String prenom, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }

    // Getters and Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    @Override
    public String toString() {
        return "Technicien{" +
               "nom='" + nom + '\'' +
               ", prenom='" + prenom + '\'' +
               ", specialite='" + specialite + '\'' +
               '}';
    }  
}
