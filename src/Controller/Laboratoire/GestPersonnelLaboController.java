/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Laboratoire;

import Model.Labo.Laboratoire;
import Model.Labo.Personne;
import Model.Labo.Personnel;
import Model.Labo.Stagiaire;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
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
public class GestPersonnelLaboController implements Initializable {

    @FXML
    private TableColumn<Personnel, String> id;
    @FXML
    private TableColumn<Personnel, String> colNom;
    @FXML
    private TableColumn<Personnel, String> colPrenom;
    @FXML
    private TableColumn<Personnel, ?> colTel;
    @FXML
    private TableColumn<Personnel, String> colMail;
    @FXML
    private TableColumn<Personnel, String> colPost;
    @FXML
    private TableColumn<Personnel, Boolean> colChef;
    @FXML
    private TableColumn<Stagiaire, String> colAcces1;
    @FXML
    private TableColumn<Stagiaire, String> colNom1;
    @FXML
    private TableColumn<Stagiaire, String> colPrenom1;
    @FXML
    private TableColumn<Stagiaire, Long> colTel1;
    @FXML
    private TableColumn<Stagiaire, String> colMail1;
    @FXML
    private TableColumn<Stagiaire, String> colDUre;
    @FXML
    private TableColumn<Stagiaire, String> colNiv;
    @FXML
    private TableColumn<Stagiaire, LocalDate> colDeb;
    @FXML
    private TableView<Personne> tablePersonnel;
    @FXML
    private TableView<Personne> tableStagiaire;

    private Laboratoire gpl=new Laboratoire("MonLaboMedicale","Bizerte",77777777);
    private Personne persSelect;
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
        //Initialisation de la liste de personnel
        
      gpl.ajouterPersonnel(new Stagiaire("licence","1 mois","kane","cheikh","ck@gmail.com",77777,"A",LocalDate.parse("2024-12-26")));
      gpl.ajouterPersonnel(new Personnel("préléveur",false,"ben said","yassin","bsy@gmail.com",88888,"C"));
        // TODO
        id.setCellValueFactory(new PropertyValueFactory<>("acces"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prénom"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        colPost.setCellValueFactory(new PropertyValueFactory<>("PosteOcc"));
        colChef.setCellValueFactory(new PropertyValueFactory<>("isChef"));
        colAcces1.setCellValueFactory(new PropertyValueFactory<>("acces"));
        colNom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom1.setCellValueFactory(new PropertyValueFactory<>("prénom"));
        colTel1.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colMail1.setCellValueFactory(new PropertyValueFactory<>("mail"));
        colDUre.setCellValueFactory(new PropertyValueFactory<>("duree"));
        colNiv.setCellValueFactory(new PropertyValueFactory<>("niveau"));
        colDeb.setCellValueFactory(new PropertyValueFactory<>("datDeb"));
         tablePersonnel.setItems(new FilteredList<>(gpl.getListPers(), p -> p instanceof Personnel));
         tablePersonnel.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        persSelect = newSelection;
        });
         tableStagiaire.setItems(new FilteredList<>(gpl.getListPers(), p -> p instanceof Stagiaire));
         tableStagiaire.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        persSelect = newSelection;
        });
         tablePersonnel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
         tableStagiaire.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }    

    @FXML
    private void AjouterPers(MouseEvent event) {
        try {
            // Charger l'interface de modification
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Labo/AjoutPersonnel.fxml"));
            Parent root = loader.load();
            
            // Passer la liste des patients au contrôleur d'ajout
            AjoutPersonnelController ajouterController = loader.getController();
            ajouterController.setPersonnel(gpl.getListPers());
            
           Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            // Afficher l'interface
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Ajouter Personnel");
            stage.show();
            // Fermer la fenêtre actuelle une fois l'ajout effectué 
            stage.setOnHidden(ev -> {
                // Rafraîchir l'affichage des patients après la modification
                tablePersonnel.refresh();
            });
         } catch (IOException e) {
            e.printStackTrace();
        }   
    }

    @FXML
    private void supprimPersonnel(ActionEvent event) {
         if (persSelect != null) {
        // Supprimer le patient de la liste
        gpl.getListPers().remove(persSelect);
        //patientSelectionne = null; // Réinitialiser après suppression
        tablePersonnel.refresh();
    } 
    }

    @FXML
    private void AjouterStag(MouseEvent event) {
        try {
            // Charger l'interface de modification
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Labo/AjoutStagiaire.fxml"));
            Parent root = loader.load();
            
            // Passer la liste des patients au contrôleur d'ajout
            AjoutStagiaireController ajouterController = loader.getController();
            ajouterController.setPersonnel(gpl.getListPers());
            
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            // Afficher l'interface
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Ajouter Stagiaire");
            stage.show();
            // Fermer la fenêtre actuelle une fois l'ajout effectué 
            stage.setOnHidden(ev -> {
                // Rafraîchir l'affichage des patients après la modification
                tableStagiaire.refresh();
            });
         } catch (IOException e) {
            e.printStackTrace();
        }   
    }

    @FXML
    private void supprimStagiare(ActionEvent event) {
        if (persSelect != null) {
        // Supprimer le patient de la liste
        gpl.getListPers().remove(persSelect);
        //patientSelectionne = null; // Réinitialiser après suppression
        tableStagiaire.refresh();
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
