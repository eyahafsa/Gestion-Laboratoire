/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Laboratoire;

import Model.Labo.ErreurRdvExistante;
import Model.Labo.GestRdv;
import Model.Labo.RendezVous;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class GestionRDVController implements Initializable {

    @FXML
    private TableView<RendezVous> tableRdvs;
    @FXML
    private TableColumn<RendezVous, Integer> idRV;
    @FXML
    private TableColumn<RendezVous, LocalDate> colDate;
    @FXML
    private TableColumn<RendezVous, LocalTime> colHeure;
    @FXML
    private TableColumn<RendezVous, String> colType;
    @FXML
    private TableColumn<RendezVous, Integer> colIdPatient;
    
    private GestRdv r=new GestRdv();
    private RendezVous rvSelect;
    
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
        try {
            // TODO
            r.ajouterRdv(new RendezVous(1,26,LocalDate.parse("2024-12-26"),LocalTime.parse("17:30:40"),"dialyse"));
        } catch (ErreurRdvExistante ex) {
            Logger.getLogger(GestionRDVController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        idRV.setCellValueFactory(new PropertyValueFactory<>("idRdv"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("dateR"));
        colHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        colType.setCellValueFactory(new PropertyValueFactory<>("typesAnalyses"));
        colIdPatient.setCellValueFactory(new PropertyValueFactory<>("idPatient"));
        
        
         tableRdvs.setItems(r.getListTousLesRdv());
         tableRdvs.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        rvSelect = newSelection;
        });
         tableRdvs.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }    

    @FXML
    private void AjouterRdv(MouseEvent event) {
        try {
            // Charger l'interface de modification
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Labo/AjoutRdv.fxml"));
            Parent root = loader.load();
            
            // Passer la liste des patients au contrôleur d'ajout
            AjoutRdvController ajouterController = loader.getController();
            ajouterController.setRdvs(r.getListTousLesRdv());
            
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            // Afficher l'interface
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Ajouter Rendez-vous");
            stage.show();
            // Fermer la fenêtre actuelle une fois l'ajout effectué 
            stage.setOnHidden(ev -> {
                // Rafraîchir l'affichage des patients après la modification
                tableRdvs.refresh();
            });
         } catch (IOException e) {
            e.printStackTrace();
        }   

    }

    @FXML
    private void modifRdv(ActionEvent event) {
        if (rvSelect != null) {
        try {
            // Charger l'interface de modification
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Labo/ModificationRdv.fxml"));
            Parent root = loader.load();

            // Obtenir le contrôleur et passer les données
                Controller.Laboratoire.ModificationRdvController modifierController = loader.getController();
            modifierController.setRdv(rvSelect);
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            modifierController.setPreviousScene(currentStage.getScene());
            // Afficher l'interface
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Modifier Rendez-vous");
            stage.show();
            // Fermer la fenêtre actuelle une fois la modification faite
            stage.setOnHidden(ev -> {
                // Rafraîchir l'affichage des patients après la modification
                tableRdvs.refresh();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    @FXML
    private void supprimRdv(ActionEvent event) {
        if (rvSelect != null) {
        // Supprimer le patient de la liste
        r.getListTousLesRdv().remove(rvSelect);
        //patientSelectionne = null; // Réinitialiser après suppression
        tableRdvs.refresh();
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
