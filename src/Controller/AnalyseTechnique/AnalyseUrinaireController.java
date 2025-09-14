/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.AnalyseTechnique;

import Model.Analyse.AnalyseUrine;
import Model.Analyse.GestAnaUrine;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayach
 */
public class AnalyseUrinaireController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private DatePicker DateR;
    @FXML
    private DatePicker DateA;
    @FXML
    private TextField ph;
    @FXML
    private TextField glucose;
    @FXML
    private TextField proteines;
    @FXML
    private TextField leucocytes;
    @FXML
    private TextField sangocc;
    @FXML
    private TextField idP;
    @FXML
    private Button engbutton;

    private boolean isEnregistrementComplete;

    private AnalyseUrine analyseUrinaireAjoutee;

    private ObservableList<AnalyseUrine> analysesurinaires;
    @FXML
    private TextField Tfprix;
    
    @FXML
    private Button back;
    private Scene previousScene;
    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }

    public void setAnalysesUrines(ObservableList<AnalyseUrine> analysesurinaires) {
        this.analysesurinaires = analysesurinaires;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setIsEnregistrementComplete(false);
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/AnalyseTechnique/Analyse.fxml"));
                Parent root = loader.load();

                Stage currentStage = (Stage) backButton.getScene().getWindow();
                currentStage.setScene(new Scene(root));

                System.out.println("Retour à l'interface principale Analyse...");
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Erreur", "Impossible de charger l'interface Analyse.", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    private void handleEnregistrer(ActionEvent event) {

        try {
            int idPrelevement = Integer.parseInt(idP.getText());
            LocalDate dateAnalyse = DateA.getValue();
            LocalDate dateResultat = DateR.getValue();
            float phValue = Float.parseFloat(ph.getText());
            float glucoseLevel = Float.parseFloat(glucose.getText());
            float proteinLevel = Float.parseFloat(proteines.getText());
            float leucocyteCount = Float.parseFloat(leucocytes.getText());
            float presenceOfBlood = Float.parseFloat(sangocc.getText());
            Double prix=Double.parseDouble(Tfprix.getText());
            AnalyseUrine analyseUrinaireAjoutee = new AnalyseUrine(
                    idPrelevement,
                    java.sql.Date.valueOf(dateAnalyse),
                    java.sql.Date.valueOf(dateResultat),
                    prix,
                    phValue,
                    glucoseLevel,
                    proteinLevel,
                    presenceOfBlood,
                    leucocyteCount
            );

            System.out.println("Analyse Urinaire enregistrée :");
            System.out.println("ID Prélèvement : " + idPrelevement);
            System.out.println("Date Analyse : " + dateAnalyse);
            System.out.println("Date Résultat : " + dateResultat);
            System.out.println("pH : " + phValue);
            System.out.println("Glucose : " + glucoseLevel);
            System.out.println("Protéines : " + proteinLevel);
            System.out.println("Leucocytes : " + leucocyteCount);
            System.out.println("Présence de sang : " + presenceOfBlood);
            
            analysesurinaires.add(analyseUrinaireAjoutee);
            
            setIsEnregistrementComplete(true);
            showAlert("Succès", "Analyse Urinaire enregistrée avec succès.", Alert.AlertType.INFORMATION);

            // Close the current stage
            Stage stage = (Stage) engbutton.getScene().getWindow();
            stage.close();

        } catch (NumberFormatException e) {
            showAlert("Erreur", "Veuillez saisir des valeurs numériques valides pour les champs correspondants.", Alert.AlertType.ERROR);
        } catch (Exception e) {
            System.out.println(e);
            showAlert("Erreur", "Une erreur est survenue : " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void setIsEnregistrementComplete(boolean val) {
        this.isEnregistrementComplete = val;
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
