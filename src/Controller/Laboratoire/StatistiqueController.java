/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Laboratoire;

import static Controller.AnalyseTechnique.GestAnaSanguineController.convertirLocalDateEnDate;
import static Controller.AnalyseTechnique.GestAnaUrinaireController.convertirLocalDateEnDate;
import Model.Analyse.AnalyseSanguine;
import Model.Analyse.AnalyseUrine;
import Model.Analyse.TypeSang;
import Model.Labo.Statistique;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author DELL
 */
public class StatistiqueController implements Initializable {

    @FXML
    private TableView<Map.Entry<String, Double>> tabStat;
    @FXML
    private TableColumn<Map.Entry<String, Double>, String> colTyp;
    @FXML
    private TableColumn<Map.Entry<String, Double>, Double> colRev;
    @FXML
    private Label dat;

    private Statistique stat;
    
    private Scene previousScene; // Stocke la scène précédente
    @FXML
    private Button back;

    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }
    /**
     * Initializes the controller class.
     */
    
    public static Date convertirLocalDateEnDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stat=new Statistique(1,LocalDateTime.now());
        stat.ajouterAnalyse(new AnalyseSanguine(
                1,
                convertirLocalDateEnDate(LocalDate.now()), // Conversion de LocalDate à Date pour la date de l'analyse
                convertirLocalDateEnDate(LocalDate.now().plusDays(3)), // Conversion pour la date de résultat
                45,
                TypeSang.A_POSITIF,
                4,
                7,
                13,
                250,
                180
        ));
        stat.ajouterAnalyse(new AnalyseUrine(
                1,
                convertirLocalDateEnDate(LocalDate.now()), // Conversion de LocalDate à Date pour la date de l'analyse
                convertirLocalDateEnDate(LocalDate.now().plusDays(3)), // Conversion pour la date de résultat
                60,
                4,
                7,
                13,
                250,
                180));
        stat.ajouterAnalyse(new AnalyseSanguine(
                1,
                convertirLocalDateEnDate(LocalDate.now()), // Conversion de LocalDate à Date pour la date de l'analyse
                convertirLocalDateEnDate(LocalDate.now().plusDays(3)), // Conversion pour la date de résultat
                30,
                TypeSang.O_NEGATIF,
                2,
                17,
                12,
                360,
                280
        ));
        stat.calculerRevenuParAnalyse();
        stat.afficherRevenuParAn();
         colTyp.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getKey()));
        colRev.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getValue()));


        ObservableList<Map.Entry<String, Double>> data = FXCollections.observableArrayList(stat.getRevenusParAnalyse().entrySet());
        tabStat.setItems(data);
        
        dat.setText(stat.getDate().toString());
    }    
    @FXML
    private void handleback(ActionEvent event) {
        if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene); // Revenir à la scène précédente
        }
    }
}
