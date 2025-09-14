/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Labo;
  import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author DELL
 */
public class GestionPatient {
  
    private static ObservableList<Patient> patients;

    public GestionPatient() {
        this.patients = FXCollections.observableArrayList();
    }

    public void ajouterPatient(Patient patient) {
        this.patients.add(patient);
    }

    public ObservableList<Patient> getPatients() {
        return patients;
    }
    
    
}


