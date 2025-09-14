/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Laboratoire;

import Model.Labo.GestionPatient;
import Model.Labo.Patient;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class GestionPatientController implements Initializable {

    @FXML
    private TableColumn<Patient, Integer> id;
    @FXML
    private TableColumn<Patient, String> colNom;
    @FXML
    private TableColumn<Patient, String> colPrenom;
    @FXML
    private TableColumn<Patient, Double> colTel;
    @FXML
    private TableColumn<Patient, String> colMail;
    @FXML
    private TableColumn<Patient, String> colUrg;
    @FXML
    private TableView<Patient> tablePatients;
    private GestionPatient p=new GestionPatient();
    
    private Patient patientSelectionne;

    private Scene previousScene; // Stocke la scène précédente
    @FXML
    private Button back;

    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        p.ajouterPatient(new Patient(1,"ndeyesall","sall","Ouly","sallouly2001@gmail.com",785017875));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prénom"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        colUrg.setCellValueFactory(new PropertyValueFactory<>("ContactDUrgence"));
         tablePatients.setItems(p.getPatients());
         tablePatients.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        patientSelectionne = newSelection;
        });
         tablePatients.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }    
    @FXML
    private void AjouterPatient(MouseEvent event) {
        try {
            // Charger l'interface de modification
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Labo/AjoutPatient.fxml"));
            Parent root = loader.load();
            // Passer la liste des patients au contrôleur d'ajout
            AjoutPatientController ajouterController = loader.getController();
            ajouterController.setPatients(p.getPatients());
            
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            // Afficher l'interface
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Ajouter Patient");
            stage.show();
            // Fermer la fenêtre actuelle une fois l'ajout effectué 
            stage.setOnHidden(ev -> {
                // Rafraîchir l'affichage des patients après la modification
                tablePatients.refresh();
            });
         } catch (IOException e) {
            e.printStackTrace();
        }   

}
    

    @FXML
    private void modifPatient(ActionEvent event) {
        if (patientSelectionne != null) {
        try {
            // Charger l'interface de modification
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Labo/ModificationPatient.fxml"));
            Parent root = loader.load();

            // Obtenir le contrôleur et passer les données
                Controller.Laboratoire.ModificationPatientController modifierController = loader.getController();
            modifierController.setPatient(patientSelectionne);

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            modifierController.setPreviousScene(currentStage.getScene());
            // Afficher l'interface
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Modifier Patient");
            stage.show();
            // Fermer la fenêtre actuelle une fois la modification faite
            stage.setOnHidden(ev -> {
                // Rafraîchir l'affichage des patients après la modification
                tablePatients.refresh();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    @FXML
    private void supprimPatient(ActionEvent event) {
        if (patientSelectionne != null) {
        // Supprimer le patient de la liste
        p.getPatients().remove(patientSelectionne);
        //patientSelectionne = null; // Réinitialiser après suppression
        tablePatients.refresh();
    } 
    }
    
    @FXML
    private void handleback(ActionEvent event) {
        if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene); // Revenir à la scène précédente
        }
    }
    
}
