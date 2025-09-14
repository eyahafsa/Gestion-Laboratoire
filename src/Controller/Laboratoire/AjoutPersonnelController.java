/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Laboratoire;

import Model.Labo.Patient;
import Model.Labo.Personne;
import Model.Labo.Personnel;
import Model.Labo.RendezVous;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
public class AjoutPersonnelController implements Initializable {

    Personne pers;
    private ObservableList<Personne>listP; 
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
    private TextField txtPoste;
    @FXML
    private TextField txtChef;
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

    

    void setPersonnel(ObservableList<Personne> listPers) {
         this.listP=listPers;
    }
    
    @FXML
    private void AjouterPers(ActionEvent event) {
        //patientAAjouter=new Patient();
        String n,p,m,c,a; Boolean ec;
         long t;
        a=txtId.getText();
        n=txtNom.getText();
        p=txtPrenom.getText();
        t=Integer.parseInt(txtTel.getText());
        m=txtMail.getText();
        c=txtPoste.getText();
        ec=Boolean.parseBoolean(txtChef.getText());
        pers=new Personnel(c,ec,n,p,m,t,a);
        listP.add(pers);
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
