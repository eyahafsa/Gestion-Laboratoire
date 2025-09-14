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
public final class Patient extends Personne {
    private int id;
    private String contactDUrgence;
    private List listRdv;

    public Patient(int id, String contactDUrgence, String nom, String prénom, String mail, long tel) {
        super(nom, prénom, mail, tel,null);
        this.contactDUrgence = contactDUrgence;
        this.id=id;
        listRdv=new ArrayList<RendezVous>();
    }
    
   
    public List<RendezVous> getListRdv() {
        return listRdv;
    }

    public void setListRdv(List<RendezVous> listRdv) {
        this.listRdv = listRdv;
    }

    public String getContactDUrgence() {
        return contactDUrgence;
    }

    public void setContactDUrgence(String contactDUrgence) {
        this.contactDUrgence = contactDUrgence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void afficherListRV(){
        listRdv.forEach(System.out::println);
    } 
    
    @Override
    public void afficher(){
        super.afficher();
        System.out.println("Identifiant: "+this.id+", Contact d'urgence: "+this.contactDUrgence);
        System.err.println("Liste des RDV: \n");
        this.afficherListRV();
    }
    
    void ajouterRdv(RendezVous rv){
        listRdv.add(rv);
    }
    
    
}
