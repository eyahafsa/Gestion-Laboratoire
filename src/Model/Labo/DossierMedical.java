/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Labo;


import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DELL
 */
public class DossierMedical {
    private Patient patient;
    private List listMaladie;
    

     public DossierMedical(Patient patient) {
        this.patient = patient;
        listMaladie=new ArrayList<String>();
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public List getListMaladie() {
        return listMaladie;
    }

    public void setListMaladie(List listMaladie) {
        this.listMaladie = listMaladie;
    }

    public void ajouterMaladie(String s){
        listMaladie.add(s);
    }
    
    public void afficherListMaladie(){
        listMaladie.forEach(System.out::println); 
    }
    
    public void afficher(){
        System.out.println("Patient: \n");
        patient.afficher();
        System.out.println("Liste des maladies");
        this.afficherListMaladie();
        
    }
}
