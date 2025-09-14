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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayach
 */
public class ResultatController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private TextField idAnalyse;
    @FXML
    private TextField resultat;
    private TextField description;
    @FXML
    private Button engButton;
    private boolean isEnregistrementComplete = false;
     
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
        
         if (!isEnregistrementComplete) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Attention");
        alert.setHeaderText("Enregistrement non effectué");
        alert.setContentText("Veuillez enregistrer les données avant de revenir en arrière.");
        alert.showAndWait();
    } else {
        try {
            // Charger la nouvelle interface
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Analyse/GestAnaUrine.fxml"));
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
    }

    @FXML
 
private void handleEnregistrer(ActionEvent event) {
    // Récupérer les valeurs des champs
    String analyseId = idAnalyse.getText();
    String resultatTexte = resultat.getText();
    String descriptionTexte = description.getText();

    // Vérifier si tous les champs sont remplis
    if (analyseId.isEmpty() || resultatTexte.isEmpty() || descriptionTexte.isEmpty()) {
        // Afficher une alerte pour les champs manquants
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Champs manquants");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs.");
        alert.showAndWait();
    } else {
        // Enregistrement complété
        isEnregistrementComplete = true;

        // Afficher un message de succès
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("Enregistrement réalisé avec succès !");
        alert.showAndWait();

        // Réinitialiser les champs après enregistrement si nécessaire
        idAnalyse.clear();
        resultat.clear();
        description.clear();
    }
}

    private void showAlert(String title, String message){
        Alert.AlertType alertType = null;
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
