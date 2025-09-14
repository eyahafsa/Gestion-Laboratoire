/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Equipement;
import java.util.Date;
/**
 *
 * @author Extreme PC
 */
public sealed class Equipement permits EquipementBiologique,EquipementPhysique{
    private String Nom;
    private String Marque;
    private int NumSerie;
    private Date dateAchat;
    private String Etat;
  public Equipement(String Nom,String Marque,int NumSerie,Date date,String Etat){
  this.Nom=Nom;
  this.Marque=Marque;
  this.NumSerie=NumSerie;
  this.dateAchat=date;
  this.Etat=Etat;
  }
  public String getNom(){
  return Nom;
  }
   public String getMarque() {
        return Marque;
    }

    public int getNumeroSerie() {
        return NumSerie;
    }

    public int getNumSerie() {
        return NumSerie;
    }

    public void setNumSerie(int NumSerie) {
        this.NumSerie = NumSerie;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        this.Etat = etat;
    }
  public void setNom (String nom){
  this.Nom=nom;
  }
public void afficherDetails() {
        System.out.println("Nom: " + Nom);
        System.out.println("Marque: " + Marque);
        System.out.println("Numéro de Série: " + NumSerie);
        System.out.println("Date d'Achat: " + dateAchat);
        System.out.println("État: " + Etat);
    }
public final boolean estConforme(){
 if (Etat.equals("Bon"))
  { return true;}
 else
  {return false;}
  };

}



