/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.AnalyseTechnique;

import Model.Technique.Technicien;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayach
 */
public class TechnicienController implements Initializable {

    @FXML
    private TextField prenomT;
    @FXML
    private TextField nomT;
    @FXML
    private ComboBox<String> specialiteTechnicien;
    @FXML
    private Button boutonRetour;
    @FXML
    private Button boutonEng;
    private Technicien technicien;
   
    private boolean isEnregistrementComplete = false;

    private ObservableList<Technicien> techniciens;

    @FXML
    private Button back;
    private Scene previousScene;
    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }
    
    public void setTechniciens(ObservableList<Technicien> techniciens) {
        this.techniciens = techniciens;
    }

    public ObservableList<Technicien> getTechniciens() {
        return techniciens;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        specialiteTechnicien.getItems().addAll(
                "électronique", "mécanique", "électroméca"
        );
    }

    @FXML
    private void handleBoutonRetour(ActionEvent event) {

        if (!isEnregistrementComplete) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setHeaderText("Enregistrement non effectué");
            alert.setContentText("Veuillez enregistrer les données avant de revenir en arrière.");
            alert.showAndWait();
        } else {
            try {
                // Charger la nouvelle interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Technicien/Service.fxml"));
                Parent root = loader.load();

                // Obtenir la scène actuelle et remplacer le contenu
                Stage currentStage = (Stage) boutonRetour.getScene().getWindow();
                currentStage.setScene(new Scene(root));

                System.out.println("Retour à l'interface Service...");
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
    private void handleBoutonEng(ActionEvent event) {
 try{
        String nom = nomT.getText();
        String prenom = prenomT.getText();
        String specialite = specialiteTechnicien.getValue();

        Technicien technicien = new Technicien(nom, prenom, specialite);
        techniciens.add(technicien);
        
         System.out.println("Technicien enregistrée :");
            System.out.println("Identifiant du prelevement: " + nom);
            System.out.println("Date Analyse: " +  prenom);
            System.out.println("Date Résultat: " + specialite);
        
        isEnregistrementComplete = true;
          showAlert("Succès", "Analyse enregistrée avec succès.", Alert.AlertType.INFORMATION);

            Stage stage = (Stage) boutonEng.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            showAlert("Erreur", "Veuillez saisir des valeurs numériques valides pour les champs correspondants.", Alert.AlertType.ERROR);
        } catch (Exception e) {
            System.out.println(e);
            showAlert("Erreur", "Une erreur est survenue : " + e.getMessage(), Alert.AlertType.ERROR);
        }


        // Pass the technicien object to ServiceController
    }
    
    private void showAlert(String title, String message, Alert.AlertType alertType) {
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
