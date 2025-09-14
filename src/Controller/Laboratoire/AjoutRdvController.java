/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Laboratoire;

import Model.Labo.Patient;
import Model.Labo.RendezVous;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AjoutRdvController implements Initializable {

    @FXML
    private TextField txtId;
    @FXML
    private DatePicker txtDate;
    @FXML
    private TextField txtHeure;
    @FXML
    private TextField txtTyp;
    @FXML
    private TextField txtIdPatient;
    
    private ObservableList<RendezVous> listRv;
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
        // TODO
    }    

    void setRdvs(ObservableList<RendezVous> listTousLesRdv) {
            this.listRv=listTousLesRdv;
    }

    @FXML
    private void AjouterRv(ActionEvent event) {
        int idR,idP; String ta;
        LocalDate d; LocalTime t;
        idR=Integer.parseInt(txtId.getText());
        idP=Integer.parseInt(txtIdPatient.getText());
        ta=txtTyp.getText();
        d=txtDate.getValue();
        t=LocalTime.parse(txtHeure.getText());
        listRv.add(new RendezVous(idR,idP,d,t,ta));
        ((Stage) txtId.getScene().getWindow()).close();
    }

    @FXML
    private void handleback(ActionEvent event) {
       if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene); // Revenir à la scène précédente
        }
    }
    
}
