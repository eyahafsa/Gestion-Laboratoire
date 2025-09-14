/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.AnalyseTechnique;

import Model.Technique.GestTechnicien;
import Model.Technique.Technicien;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayach
 */
public class ServiceController implements Initializable {

    @FXML
    private VBox respS;
    @FXML
    private TextField nomS;
    @FXML
    private TextField nomRespon;
    @FXML
    private TableView<Technicien> tableTechniciens;
    @FXML
    private TableColumn<Technicien, String> colNom;
    @FXML
    private TableColumn<Technicien, String> colPrenom;
    @FXML
    private TableColumn<Technicien, String> colSpecialite;
    @FXML
    private Button boutonRetour;
    @FXML
    private Button boutonajouter;
    
    ObservableList<Technicien> listtechniciens = FXCollections.observableArrayList();
     private GestTechnicien  tech= new  GestTechnicien();
     private Technicien technicienSelectionne;

    
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
        tech.ajouterTechnicien(new Technicien("ahmed","karamisha","mécanique"));
        colNom.setCellValueFactory(new PropertyValueFactory<Technicien, String>("Nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<Technicien, String>("Prenom")); 
        colSpecialite.setCellValueFactory(new PropertyValueFactory<Technicien, String>("specialite")); 
        tableTechniciens.setItems(tech.getTechnicien());
        
        
        tableTechniciens.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
         technicienSelectionne = newSelection; });
       
        
    }  
               

    @FXML
    private void handleRetour(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Personne/Menu.fxml"));
            Parent root = loader.load();
            // Récupérer le contrôleur de la nouvelle interface
            
            Stage stage = (Stage) boutonRetour.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            
            
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }

    @FXML
    private void handleAjouterTech(ActionEvent event) {
        
        try {
            // Charger l'interface d'ajout
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Technicien/Technicien.fxml"));
            Parent root = loader.load();

            // Passer la liste des analyses au contrôleur d'ajout
            TechnicienController ajoutController = loader.getController();
            ajoutController.setTechniciens(tech.getTechnicien());
//etAnalysessanguines(a.getAnaSanguines()
            // Afficher la fenêtre d'ajout
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Ajouter technicien");
            stage.show();

            // Rafraîchir la table après l'ajout
            stage.setOnHidden(ev -> tableTechniciens.refresh());
        } catch (IOException e) {
            e.printStackTrace();
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
    

