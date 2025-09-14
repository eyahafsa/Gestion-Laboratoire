/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.AnalyseTechnique;

import Model.Analyse.GestAnaSanguine;
import Model.Analyse.AnalyseSanguine;
import Model.Analyse.TypeSang;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayach
 */
public class GestAnaSanguineController implements Initializable {

    @FXML
    private TableColumn<AnalyseSanguine, Integer> colidp;
    @FXML
    private TableColumn<AnalyseSanguine, LocalDate> coldateA;
    @FXML
    private TableColumn<AnalyseSanguine, LocalDate> coldateR;
    @FXML
    private TableColumn<AnalyseSanguine, TypeSang> coltypeS;
    @FXML
    private TableColumn<AnalyseSanguine, Float> colgr;
    @FXML
    private TableColumn<AnalyseSanguine, Float> colgb;
    @FXML
    private TableColumn<AnalyseSanguine, Float> colhemo;
    @FXML
    private TableColumn<AnalyseSanguine, Float> colpla;
    @FXML
    private TableColumn<AnalyseSanguine, Float> colch;
    @FXML
    private Button boutonSupp;
    @FXML
    private Button boutonAjou;
    @FXML
    private TableView<AnalyseSanguine> tableanalysesanguine;
    
    private GestAnaSanguine a = new GestAnaSanguine();

    private AnalyseSanguine analyseSSelectionne;

    public static Date convertirLocalDateEnDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    @FXML
    private TextField searchField;

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
        a.ajouterAnalyseSanguine(new AnalyseSanguine(
                1,
                convertirLocalDateEnDate(LocalDate.now()), // Conversion de LocalDate à Date pour la date de l'analyse
                convertirLocalDateEnDate(LocalDate.now().plusDays(3)), // Conversion pour la date de résultat
                40,
                TypeSang.A_POSITIF,
                4,
                7,
                13,
                250,
                180
        ));// Initialisation des colonnes
        colidp.setCellValueFactory(new PropertyValueFactory<>("id"));
        coldateA.setCellValueFactory(new PropertyValueFactory<>("dateAnalyse"));
        coldateR.setCellValueFactory(new PropertyValueFactory<>("dateResultat"));
        coltypeS.setCellValueFactory(new PropertyValueFactory<>("typeSang"));
        colgr.setCellValueFactory(new PropertyValueFactory<>("globulesRouges"));
        colgb.setCellValueFactory(new PropertyValueFactory<>("globulesBlancs"));
        colhemo.setCellValueFactory(new PropertyValueFactory<>("tauxHemoglobine"));
        colpla.setCellValueFactory(new PropertyValueFactory<>("tauxPlaquettes"));
        colch.setCellValueFactory(new PropertyValueFactory<>("cholesterol"));
        //  Charger les données dans la table   
        tableanalysesanguine.setItems(a.getAnaSanguines());
        // Listener pour sélectionner une analyse dans la table
        tableanalysesanguine.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            analyseSSelectionne = newSelection;
        });

    }

    @FXML
    private void SuppAnaSanguine(ActionEvent event) {

        if (analyseSSelectionne != null) {
            a.supprimerAnalyseSanguine(analyseSSelectionne);
            tableanalysesanguine.refresh();
            showAlert("Succès", "Analyse sanguine supprimée avec succès.", Alert.AlertType.INFORMATION);
        } else {
            showAlert("Erreur", "Veuillez sélectionner une analyse sanguine à supprimer.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void searchAnaSanguine(ActionEvent event) {
        String searchText = searchField.getText().toLowerCase();
        ObservableList<AnalyseSanguine> filteredList = FXCollections.observableArrayList();

        for (AnalyseSanguine analyse : a.getAnaSanguines()) {
            if (String.valueOf(analyse.getId()).contains(searchText)
                    || analyse.getTypeSang().toString().toLowerCase().contains(searchText)) {
                filteredList.add(analyse);
            }
        }

        tableanalysesanguine.setItems(filteredList);
        if (filteredList.isEmpty()) {
            showAlert("Information", "Aucune analyse correspondant à la recherche.", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    private void ajouterAnaSanguine(ActionEvent event) {
        try {
            // Charger l'interface d'ajout
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/AnalyseTechnique/AnalyseSanguine.fxml"));
            Parent root = loader.load();

            // Passer la liste des analyses au contrôleur d'ajout
            AnalyseSanguineController ajoutController = loader.getController();
            ajoutController.setAnalysessanguines(a.getAnaSanguines());

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajoutController.setPreviousScene(currentStage.getScene());
            // Afficher l'interface
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Ajouter une Analyse Sanguine");
            stage.show();

            // Rafraîchir la table après l'ajout
            stage.setOnHidden(ev -> tableanalysesanguine.refresh());
        } catch (IOException e) {
            e.printStackTrace();
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
