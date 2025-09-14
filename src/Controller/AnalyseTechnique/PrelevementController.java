/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.AnalyseTechnique;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayach
 */
public class PrelevementController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private TextField patientIdField;
    @FXML
    private TextField patientNameField;
    @FXML
    private TextField tubeNumberField;
    @FXML
    private DatePicker datePrelevementPicker;
    @FXML
    private Button validerButton;

    @FXML
    private Button back;
    private Scene previousScene;
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

    @FXML
    private void handleBack(ActionEvent event) {
        try {
            // Charger la nouvelle interface
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Analyse/Analyse.fxml"));
            Parent root = loader.load();

            // Obtenir la scène actuelle et remplacer le contenu
            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(new Scene(root));

            System.out.println("Retour à l'interface Analyse1...");
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Impossible de charger l'interface");
            alert.setContentText("Une erreur est survenue lors du chargement de l'interface Analyse.");
            alert.showAndWait();
        }

    }
   
        
       @FXML
private void handlevalider(ActionEvent event) {
    // Récupérer les valeurs des champs
    String patientId = patientIdField.getText();
    String patientName = patientNameField.getText();
    String tubeNumber = tubeNumberField.getText();
    LocalDate datePrelevement = datePrelevementPicker.getValue();

    // Vérifier si tous les champs sont remplis
    if (patientId.isEmpty() || patientName.isEmpty() || tubeNumber.isEmpty() || datePrelevement == null) {
        // Afficher une alerte si un champ est vide
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Champs manquants");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs.");
        alert.showAndWait();
    } else {
        // Afficher un message de succès
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("Enregistrement réalisé avec succès !");
        alert.showAndWait();

        // Réinitialiser les champs si nécessaire
        patientIdField.clear();
        patientNameField.clear();
        tubeNumberField.clear();
        datePrelevementPicker.setValue(null);
    }
}
 
        
     
          
    

    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

@FXML
    private void handleback(ActionEvent event) {
        if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene); // Revenir à la scène précédente
        }
    }
}

    
    

