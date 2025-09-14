package Controller.CommandeEquipement;

import Model.Commande.Commande;
import Model.Commande.CommandeInvalideException;
import Model.Commande.CommandeNonAnnulableException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommandeFxmlController implements Initializable {

    @FXML private Label idCommandeLabel;
    @FXML private Label dateCommandeLabel;
    @FXML private ListView<String> materielsListView;
    @FXML private Button validerButton;
    @FXML private Button annulerButton;
    @FXML private Button addArticleButton;
    @FXML private Button removeArticleButton;
    @FXML private Label montantTotalLabel;

    private ObservableList<String> materiels;
    private Commande commande;
    @FXML
    private Button back;
 private Scene previousScene; // Stocke la scène précédente

    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }
    
   @Override
public void initialize(URL url, ResourceBundle rb) {
    // Initialize the Commande object with a default ID, an empty map, and today's date
    commande = new Commande(1, new HashMap<>(), LocalDate.now());

    // Set the labels with default values
    idCommandeLabel.setText(String.valueOf(commande.getIdCommande()));
    dateCommandeLabel.setText(commande.getDateCommande().toString());

    // Initialize the materiels list and bind it to the ListView
    materiels = FXCollections.observableArrayList();
    materielsListView.setItems(materiels);
    updateMontantTotal(); // Initialiser le montant total
    // Set button actions
    validerButton.setOnAction(event -> validerCommande());
    annulerButton.setOnAction(event -> annulerCommande());
    addArticleButton.setOnAction(event -> addArticle());
    removeArticleButton.setOnAction(event -> removeArticle());
}

private void annulerCommande() {
    try {
        commande.annulerCommande();
        showInfo("Commande annulée avec succès !");
        // Reset the commande
        commande = new Commande(commande.getIdCommande() + 1, new HashMap<>(), LocalDate.now());
        idCommandeLabel.setText(String.valueOf(commande.getIdCommande()));
        dateCommandeLabel.setText(commande.getDateCommande().toString());
        materiels.clear();
    } catch (CommandeNonAnnulableException e) {
        showError("Erreur d'annulation : " + e.getMessage());
    }
}
private void validerCommande() {
    try {
        commande.validerCommande(); // Calls the method from the Commande class
        showInfo("Commande validée avec succès !");
    } catch (CommandeInvalideException e) {
        showError("Erreur de validation : " + e.getMessage());
    }
}

    @FXML
    private void addArticle() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ajouter un article");
        dialog.setHeaderText("Entrez les détails de l'article");
        dialog.setContentText("Format : NomArticle:Prix");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String input = result.get();
            String[] parts = input.split(":");
            if (parts.length == 2) {
                try {
                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    commande.addMateriel(name, price);
                    materiels.add(name + ": " + price);
                    updateMontantTotal(); // Met à jour le montant total
                } catch (NumberFormatException e) {
                    showError("Prix invalide. Veuillez entrer un nombre.");
                }
            } else {
                showError("Format invalide. Utilisez NomArticle:Prix.");
            }
        }
    }

    @FXML
    private void removeArticle() {
        String selectedItem = materielsListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String name = selectedItem.split(":")[0].trim();
            commande.removeMateriel(name);
            materiels.remove(selectedItem);
            updateMontantTotal(); // Met à jour le montant total
        } else {
            showError("Veuillez sélectionner un article à supprimer.");
        }
    }
    private void updateMontantTotal() {
    double total = commande.getMateriels().values().stream()
                           .mapToDouble(Double::doubleValue)
                           .sum();
    montantTotalLabel.setText("Montant Total: " + total);
}

    private void showInfo(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
   
    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
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
