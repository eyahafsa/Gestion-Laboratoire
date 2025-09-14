/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Laboratoire;

import Model.Labo.Patient;
import Model.Labo.RendezVous;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ModificationPatientController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtId;
    
    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtPrenom;

    @FXML
    private TextField txtTel;
    
    @FXML
    private TextField txtMail;
    
    @FXML
    private TextField txtConUrg;

    private Patient patientAModifier;
    
    private Scene previousScene; // Stocke la scène précédente
    @FXML
    private Button back;

    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setPatient(Patient patient) {
        this.patientAModifier = patient;

        // Préremplir les champs
        txtId.setText(Integer.toString(patient.getId()));
        txtNom.setText(patient.getNom());
        txtPrenom.setText(patient.getPrénom());
        txtTel.setText(String.valueOf(patient.getTel()));
        txtMail.setText(patient.getMail());
        txtConUrg.setText(patient.getContactDUrgence());
    }

    @FXML
    private void enregistrerModif(ActionEvent event) {
        patientAModifier.setNom(txtNom.getText());
        patientAModifier.setPrénom(txtPrenom.getText());
        patientAModifier.setTel(Integer.parseInt(txtTel.getText()));
        patientAModifier.setMail(txtMail.getText());
        patientAModifier.setContactDUrgence(txtConUrg.getText());
        // Fermer la fenêtre (optionnel)
        ((Stage) txtNom.getScene().getWindow()).close();
    }

    @FXML
    private void handleback(ActionEvent event) {
        if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene); // Revenir à la scène précédente
        }
    }

   
    
}
