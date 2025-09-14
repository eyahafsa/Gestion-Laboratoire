package Controller.CommandeEquipement;

import Model.Equipement.Equipement;
import Model.Equipement.EquipementBiologique;
import Model.Equipement.EquipementPhysique;
import Model.Equipement.Stock;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StockFxmlController {

    @FXML
    private TextField equipementNameField;
    @FXML
    private TextField equipementBrandField;
    @FXML
    private TextField equipementStateField;
    @FXML
    private TextField equipementNumSerieField;
    @FXML
    private TextField equipementTempField; // For EquipementBiologique
    @FXML
    private TextField equipementPrecisionField; // For EquipementPhysique
    @FXML
    private TextArea outputArea;
    @FXML
    private TableView<Equipement> equipementTable;
    @FXML
    private TableColumn<Equipement, String> nomColumn;
    @FXML
    private TableColumn<Equipement, String> marqueColumn;
    @FXML
    private TableColumn<Equipement, String> etatColumn;
    @FXML
    private TableColumn<Equipement, Integer> numSerieColumn;
    @FXML
    private TableColumn<Equipement, Date> dateAchatColumn;

    private final Stock stock = new Stock();
    private final ObservableList<Equipement> equipementsData = FXCollections.observableArrayList();
    @FXML
    private Button back;

     private Scene previousScene; // Stocke la scène précédente

    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }
    public void initialize() {
        // Initialisation des colonnes de la TableView
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        marqueColumn.setCellValueFactory(new PropertyValueFactory<>("marque"));
        etatColumn.setCellValueFactory(new PropertyValueFactory<>("etat"));
        numSerieColumn.setCellValueFactory(new PropertyValueFactory<>("numSerie"));
        dateAchatColumn.setCellValueFactory(new PropertyValueFactory<>("dateAchat"));

        // Liaison des données
        equipementTable.setItems(equipementsData);
    }

    @FXML
    private void ajouterEquipementPhysique(ActionEvent event) {
        String nom = equipementNameField.getText();
        String marque = equipementBrandField.getText();
        String etat = equipementStateField.getText();
        String numSerieText = equipementNumSerieField.getText();
        Date dateAchat = new Date(); // Replace with DatePicker value if available
        String precText = equipementPrecisionField.getText();

        if (nom.isEmpty() || marque.isEmpty() || etat.isEmpty() || numSerieText.isEmpty()) {
            showAlert("Veuillez remplir tous les champs obligatoires pour l'équipement physique.");
            return;
        }

        try {
            int numSerie = Integer.parseInt(numSerieText);
            EquipementPhysique equipement = new EquipementPhysique(nom, marque, numSerie, dateAchat, etat);
            stock.ajouterEquipement(equipement);
            equipementsData.add(equipement); // Ajout à la liste observable
            showAlert("Équipement physique ajouté : " + nom);
        } catch (NumberFormatException e) {
            showAlert("Veuillez entrer un numéro de série valide.");
        }
    }

    @FXML
    private void ajouterEquipementBiologique(ActionEvent event) {
        String nom = equipementNameField.getText();
        String marque = equipementBrandField.getText();
        String etat = equipementStateField.getText();
        String numSerieText = equipementNumSerieField.getText();
        String tempText = equipementTempField.getText();
        Date dateAchat = new Date(); // Replace with DatePicker value if available

        if (nom.isEmpty() || marque.isEmpty() || etat.isEmpty() || numSerieText.isEmpty() || tempText.isEmpty()) {
            showAlert("Veuillez remplir tous les champs obligatoires pour l'équipement biologique.");
            return;
        }

        try {
            int numSerie = Integer.parseInt(numSerieText);
            double temperatureStockage = Double.parseDouble(tempText);
            EquipementBiologique equipement = new EquipementBiologique(nom, marque, numSerie, dateAchat, etat, temperatureStockage);
            stock.ajouterEquipement(equipement);
            equipementsData.add(equipement); // Ajout à la liste observable
            showAlert("Équipement biologique ajouté : " + nom);
        } catch (NumberFormatException e) {
            showAlert("Veuillez entrer des valeurs numériques valides pour le numéro de série et la température.");
        }
    }

    @FXML
    private void afficherEquipementsPhysiques(ActionEvent event) {
        outputArea.clear();
        equipementsData.setAll(stock.filtrerEquipementsPhysiques());
    }

    @FXML
    private void afficherEquipementsBiologiques(ActionEvent event) {
        outputArea.clear();
        equipementsData.setAll(stock.filtrerEquipementsBiologiques());
    }

    @FXML
    private void rechercherEquipementParNom(ActionEvent event) {
        String nom = equipementNameField.getText();
        if (nom.isEmpty()) {
            showAlert("Veuillez entrer un nom d'équipement à rechercher.");
            return;
        }
        Equipement equipement = stock.trouverEquipementParNom(nom);
        if (equipement != null) {
            outputArea.setText("Équipement trouvé : " + equipement.getNom());
            equipementsData.setAll(equipement);
        } else {
            outputArea.setText("Aucun équipement trouvé avec ce nom : " + nom);
        }
    }

    @FXML
    private void afficherQuantiteTotale(ActionEvent event) {
        int quantite = stock.calculerQuantiteTotale();
        outputArea.setText("nombre totale d'équipements : " + quantite);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
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
