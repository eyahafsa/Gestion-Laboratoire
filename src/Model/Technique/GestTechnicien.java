/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Technique;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ayach
 */
public class GestTechnicien {
     private ObservableList<Technicien> techniciens;

    public GestTechnicien () {
        this.techniciens = FXCollections.observableArrayList();
    }

    public void ajouterTechnicien(Technicien tech) {
        this.techniciens.add(tech);
    }

   
    public ObservableList<Technicien> getTechnicien() {
        return techniciens;
    }

    
    public void supprimerAnalyseUrinaire(Technicien technicienSelectionne) {
        if (technicienSelectionne != null) {
           techniciens.remove(technicienSelectionne);
        }
    }
}
