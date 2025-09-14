/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.AnalyseTechnique;

import Model.Analyse.AnalyseSanguine;
import Model.Analyse.Prelevement;
import Model.Analyse.TypeSang;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayach
 */
public class AnalyseSanguineController implements Initializable {

    @FXML
    private TextField idP;
    @FXML
    private ComboBox<TypeSang> typeSangComboBox;
    @FXML
    private TextField gr;
    @FXML
    private TextField gb;
    @FXML
    private TextField th;
    @FXML
    private TextField tp;
    @FXML
    private TextField ch;
    @FXML
    private Button engbutton;
    private Button backButton;
    @FXML
    private DatePicker DateA;

    @FXML
    private DatePicker DateR;
    private boolean isEnregistrementComplete = false;

    private AnalyseSanguine analyseSanguineAjoutee;
    
    private ObservableList<AnalyseSanguine> analysessanguines;
    @FXML
    private TextField Tfprix;
    
    @FXML
    private Button back;
    private Scene previousScene;
    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }

    public void setAnalysessanguines(ObservableList<AnalyseSanguine> analysessanguines) {
        this.analysessanguines = analysessanguines;
    }

    public AnalyseSanguine getAnalyseSanguine() {
        return analyseSanguineAjoutee;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeSangComboBox.getItems().addAll(TypeSang.values());
    }

    @FXML
    private void handleEnregistrer(ActionEvent event) {
        try {

            // Récupération des données saisies
            int idPrelevement = Integer.parseInt(idP.getText());
            LocalDate dateAnalyse = DateA.getValue();
            LocalDate dateResultat = DateR.getValue();
            TypeSang typeSang = typeSangComboBox.getValue();
            float globulesRouges = Float.parseFloat(gr.getText());
            float globulesBlancs = Float.parseFloat(gb.getText());
            float tauxHemoglobine = Float.parseFloat(th.getText());
            float tauxPlaquettes = Float.parseFloat(tp.getText());
            float cholesterol = Float.parseFloat(ch.getText());
            Double prix=Double.parseDouble(Tfprix.getText());
            AnalyseSanguine analyseSanguineAjoutee = new AnalyseSanguine(
                    idPrelevement,
                    java.sql.Date.valueOf(dateAnalyse),
                    java.sql.Date.valueOf(dateResultat),
                    prix,
                    typeSang,
                    globulesRouges,
                    globulesBlancs,
                    tauxHemoglobine,
                    tauxPlaquettes,
                    cholesterol);

            // Ajout à la liste
            analysessanguines.add(analyseSanguineAjoutee);

            // Traitement des données
            System.out.println("Analyse enregistrée :");
            System.out.println("Identifiant du prelevement: " + idPrelevement);
            System.out.println("Date Analyse: " + dateAnalyse);
            System.out.println("Date Résultat: " + dateResultat);
            System.out.println("Type de Sang: " + typeSang);
            System.out.println("Globules Rouges: " + globulesRouges);
            System.out.println("Globules Blancs: " + globulesBlancs);
            System.out.println("Taux Hémoglobine: " + tauxHemoglobine);
            System.out.println("Taux Plaquettes: " + tauxPlaquettes);
            System.out.println("Cholestérol: " + cholesterol);
            isEnregistrementComplete = true;
            // Affichage d'une alerte de confirmation
            showAlert("Succès", "Analyse enregistrée avec succès.", AlertType.INFORMATION);

            Stage stage = (Stage) engbutton.getScene().getWindow();
            //stage.close();
        } catch (NumberFormatException e) {
            showAlert("Erreur", "Veuillez saisir des valeurs numériques valides pour les champs correspondants.", AlertType.ERROR);
        } catch (Exception e) {
            System.out.println(e);
            showAlert("Erreur", "Une erreur est survenue : " + e.getMessage(), AlertType.ERROR);
        }

    }

    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void handleBack() {
        if (!isEnregistrementComplete) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setHeaderText("Enregistrement non effectué");
            alert.setContentText("Veuillez enregistrer les données avant de revenir en arrière.");
            alert.showAndWait();
        } else {
            try {
                // Charger la nouvelle interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/AnalyseTechnique/Analyse.fxml"));
                Parent root = loader.load();

                // Obtenir la scène actuelle et remplacer le contenu
                Stage currentStage = (Stage) backButton.getScene().getWindow();
                currentStage.setScene(new Scene(root));

                System.out.println("Retour à l'interface Analyse1...");
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Impossible de charger l'interface");
                alert.setContentText("Une erreur est survenue lors du chargement de l'interface Analyse.");
                alert.showAndWait();
            }

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
