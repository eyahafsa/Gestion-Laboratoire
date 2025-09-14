/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Laboratoire;

import Model.Labo.RendezVous;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
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
public class ModificationRdvController implements Initializable {
    private RendezVous rvAModifier;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtHeure;
    @FXML
    private TextField txtTyp;
    @FXML
    private TextField txtIdPatient;
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

    void setRdv(RendezVous rvSelect) {
        this.rvAModifier=rvSelect;
        txtId.setText(Integer.toString(rvSelect.getIdRdv()));
        txtDate.setText(String.valueOf(rvSelect.getDateR()));
        txtHeure.setText(String.valueOf(rvSelect.getHeure()));
        txtTyp.setText(String.valueOf(rvSelect.getTypesAnalyses()));
        txtIdPatient.setText(Integer.toString(rvSelect.getIdPatient()));
       
    }

    @FXML
    private void enregistrerModif(ActionEvent event) {
        rvAModifier.setDateR(LocalDate.parse(txtDate.getText()));
        rvAModifier.setHeure(LocalTime.parse(txtHeure.getText()));
        rvAModifier.setTypesAnalyses(txtTyp.getText());
        // Fermer la fenêtre (optionnel)
        ((Stage) txtDate.getScene().getWindow()).close();
    }

    @FXML
    private void handleback(ActionEvent event) {
        if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene); // Revenir à la scène précédente
        }
    }
    
}
