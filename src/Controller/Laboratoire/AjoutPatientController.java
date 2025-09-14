/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Laboratoire;

import Model.Labo.GestionPatient;
import Model.Labo.Patient;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AjoutPatientController implements Initializable {

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
    
    private Patient patientAAjouter;
    
    
     //private GestionPatient p=new GestionPatient();
     private ObservableList<Patient> patients;
    @FXML
    private Button back;
     
    private Scene previousScene; // Stocke la scène précédente

    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

    public void setPatients(ObservableList<Patient> patients) {
        this.patients = patients;
    }
    
    @FXML
    private void AjouterPat(ActionEvent event) {
        //patientAAjouter=new Patient();
        String n,p,m,c;
        int id; long t;
        id=Integer.parseInt(txtId.getText());
        n=txtNom.getText();
        p=txtPrenom.getText();
        t=Integer.parseInt(txtTel.getText());
        m=txtMail.getText();
        c=txtConUrg.getText();
        
        patientAAjouter=new Patient(id,c,n,p,m,t);
        patients.add(patientAAjouter);
        ((Stage) txtNom.getScene().getWindow()).close();
    }

    @FXML
    private void handleback(ActionEvent event) {
        if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene); // Revenir à la scène précédente
        }
    }
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
