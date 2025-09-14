/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.AnalyseTechnique;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayach
 */
public class AnalyseController implements Initializable {

    @FXML
    private Button boutonSang;
    @FXML
    private Button boutonurine;

    @FXML
    private Button back;
    private Scene previousScene;
    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void handleAnalyseSanguine(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/AnalyseTechnique/GestAnaSanguine.fxml"));
            Parent root = loader.load();
            // Récupérer le contrôleur de la nouvelle interface
            
           GestAnaSanguineController ajoutController = loader.getController();
         Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajoutController.setPreviousScene(currentStage.getScene());
            // Afficher l'interface
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            Logger.getLogger(AnalyseController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @FXML
    private void handleAnalyseUrinaire(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/AnalyseTechnique/GestAnaUrinaire.fxml"));
        Parent root = loader.load();
         // Récupérer le contrôleur de la nouvelle interface
         GestAnaUrinaireController ajoutController = loader.getController();
         Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajoutController.setPreviousScene(currentStage.getScene());
            // Afficher l'interface
            Stage stage = currentStage;
        stage.setScene(new Scene(root));
        stage.show();
        
     
            stage.showAndWait();
            
    }

    @FXML
    private void handleback(ActionEvent event) {
        if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene); // Revenir à la scène précédente
        }
    }
    
}
