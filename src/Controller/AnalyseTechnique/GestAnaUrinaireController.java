/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.AnalyseTechnique;

import Controller.AnalyseTechnique.AnalyseUrinaireController;
import Model.Analyse.AnalyseUrine;
import Model.Analyse.GestAnaUrine;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayach
 */
public class GestAnaUrinaireController implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private TableView<AnalyseUrine> tableanalyseurinaire;
    @FXML
    private TableColumn<AnalyseUrine, Integer> colidp;
    @FXML
    private TableColumn<AnalyseUrine, LocalDate> coldateA;
    @FXML
    private TableColumn<AnalyseUrine, LocalDate> coldateR;
    @FXML
    private TableColumn<AnalyseUrine, Float> colph;
    @FXML
    private TableColumn<AnalyseUrine, Float> colglucose;
    @FXML
    private TableColumn<AnalyseUrine, Float> colproteines;
    @FXML
    private TableColumn<AnalyseUrine, Float> colleucocytes;
    @FXML
    private TableColumn<AnalyseUrine, Float> colsa;
    @FXML
    private Button boutonAjou;
    @FXML
    private Button boutonSupp;

    private GestAnaUrine gestionUrine = new GestAnaUrine();

    private AnalyseUrine analyseSelectionnee;

    @FXML
    private Button back;
    private Scene previousScene;
    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }
    public static Date convertirLocalDateEnDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestionUrine.ajouterAnalyseUrinaire(new AnalyseUrine(
                1,
                convertirLocalDateEnDate(LocalDate.now()), // Conversion de LocalDate à Date pour la date de l'analyse
                convertirLocalDateEnDate(LocalDate.now().plusDays(3)), // Conversion pour la date de résultat
                25,
                4,
                7,
                13,
                250,
                180));

        // Initialisation des colonnes
        colidp.setCellValueFactory(new PropertyValueFactory<>("id"));
        coldateA.setCellValueFactory(new PropertyValueFactory<>("dateAnalyse"));
        coldateR.setCellValueFactory(new PropertyValueFactory<>("dateResultat"));
        colph.setCellValueFactory(new PropertyValueFactory<>("pH"));
        colglucose.setCellValueFactory(new PropertyValueFactory<>("glucose"));
        colproteines.setCellValueFactory(new PropertyValueFactory<>("proteines"));
        colleucocytes.setCellValueFactory(new PropertyValueFactory<>("leucocytes"));
        colsa.setCellValueFactory(new PropertyValueFactory<>("sangOcculte"));

        // Charger les données dans la table
        tableanalyseurinaire.setItems(gestionUrine.getAnaUrines());

        // Listener pour sélectionner une analyse dans la table
        tableanalyseurinaire.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            analyseSelectionnee = newSelection;
        });
    }

    @FXML
    private void searchAnaUrinaire(ActionEvent event) {
        String searchText = searchField.getText().toLowerCase();
        ObservableList<AnalyseUrine> filteredList = FXCollections.observableArrayList();
        if (!searchText.isEmpty()) {
            for (AnalyseUrine analyse : gestionUrine.getAnaUrines()) {
                if (String.valueOf(analyse.getId()).contains(searchText)) {
                    filteredList.add(analyse);
                }
            }
            tableanalyseurinaire.setItems(filteredList);
        }else if(searchText.isEmpty()){
            tableanalyseurinaire.setItems(gestionUrine.getAnaUrines());
        }

        if (filteredList.isEmpty()) {
            showAlert("Information", "Aucune analyse correspondant à la recherche.", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    private void ajouterAnaUrinaire(ActionEvent event) {
        try {
            // Charger l'interface d'ajout
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/AnalyseTechnique/AnalyseUrinaire.fxml"));
            Parent root = loader.load();

            // Passer la liste des analyses au contrôleur d'ajout
            AnalyseUrinaireController ajoutController = loader.getController();
            ajoutController.setAnalysesUrines(gestionUrine.getAnaUrines());

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajoutController.setPreviousScene(currentStage.getScene());
            // Afficher l'interface
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Ajouter une Analyse Urinaire");
            stage.show();

            // Rafraîchir la table après l'ajout
            stage.setOnHidden(ev -> tableanalyseurinaire.refresh());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void SuppAnaUrinaire(ActionEvent event) {
        if (analyseSelectionnee != null) {
            gestionUrine.supprimerAnalyseUrinaire(analyseSelectionnee);
            showAlert("Succès", "Analyse urinaire supprimée avec succès.", Alert.AlertType.INFORMATION);
            tableanalyseurinaire.refresh();
        } else {
            showAlert("Erreur", "Veuillez sélectionner une analyse urinaire à supprimer.", Alert.AlertType.ERROR);
        }

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
