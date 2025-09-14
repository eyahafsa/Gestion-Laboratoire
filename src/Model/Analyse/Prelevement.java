/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Analyse;
import Model.Labo.Patient;

/**
 *
 * @author ayach
 */

//apres un prelevement c'est obligatoirement interdi de changer 
//id prev ,id tube  ....enfait tout les attribut de cette classe 
//car une legere modification va affecter le resultat de l'analyse  
import java.text.SimpleDateFormat;
import java.util.Date;
public class Prelevement {

   // Attributs de la classe
    private int  idpatient;       // Le patient associé au prélèvement
    private String numeroTube; 
    private Date datePrelevement;
    // Numéro unique du tube de prélèvement

    

    // Constructeur
    public Prelevement(int patient, String numeroTube) {
        this.idpatient = patient;
        this.numeroTube = numeroTube;
         this.datePrelevement = datePrelevement;
       
    }

    // Getters et setters
    public int getPatient() {
        return idpatient;
    }

    public void setPatient(int idpatient) {
        this.idpatient = idpatient;
    }

    public String getNumeroTube() {
        return numeroTube;
    }

    public void setNumeroTube(String numeroTube) {
        this.numeroTube = numeroTube;
    }
    // Méthode pour afficher les informations du prélèvement
    @Override
    public String toString() {
        return "Prelevement{" + "idpatient=" + idpatient + ", numeroTube=" + numeroTube + ", datePrelevement=" + datePrelevement + '}';
    }
      
}
