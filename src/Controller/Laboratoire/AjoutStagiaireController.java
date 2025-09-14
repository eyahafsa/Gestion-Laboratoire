/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Laboratoire;

import Model.Labo.Personne;
import Model.Labo.Personnel;
import Model.Labo.Stagiaire;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AjoutStagiaireController implements Initializable {

    private ObservableList<Personne>listP; 
    private Personne stag;
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
    private TextField txtDure;
    @FXML
    private TextField txtNiv;
    @FXML
    private DatePicker txtDate;
    
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
    private void AjouterStag(ActionEvent event) {
          String n,p,m,c,a,ec;
         long t; LocalDate s;
        a=txtId.getText();
        n=txtNom.getText();
        p=txtPrenom.getText();
        t=Integer.parseInt(txtTel.getText());
        m=txtMail.getText();
        c=txtDure.getText();
        ec=txtNiv.getText();
        s=txtDate.getValue();
        stag=new Stagiaire(ec,c,n,p,m,t,a,s);
        listP.add(stag);
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
