package Controller.CommandeEquipement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Date;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MaintenanceFxmlController {

    @FXML
    private TextField equipementField;

    @FXML
    private TextField marqueField;

    @FXML
    private TextField numSerieField;

    @FXML
    private TextField technicienField;

    @FXML
    private DatePicker dateMaintenancePicker;

    @FXML
    private ComboBox<String> typeMaintenanceCombo;

    @FXML
    private TextArea etatAvantArea;

    @FXML
    private TextArea etatApresArea;

    @FXML
    private Button planifierButton;

    @FXML
    private Button modifierButton;


    @FXML
    private Button genererButton;
    @FXML
    private Button back;
 private Scene previousScene; // Stocke la scène précédente

    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }
    // Initialize the ComboBox with maintenance types
    public void initialize() {
        typeMaintenanceCombo.getItems().addAll("Corrective", "Préventive");
    }

    // Action to schedule maintenance
    @FXML
    public void planifierMaintenance(ActionEvent event) {
        // Get input values from the FXML form
        String nom = equipementField.getText();
        String marque = marqueField.getText();
        String numSerieString = numSerieField.getText();
        String technicien = technicienField.getText();
        Date dateMaintenance = java.sql.Date.valueOf(dateMaintenancePicker.getValue());
        String typeMaintenance = typeMaintenanceCombo.getValue();
        String etatAvant = etatAvantArea.getText();
        String etatApres = etatApresArea.getText();

        // Validate that no fields are empty
        if (nom.isEmpty() || marque.isEmpty() || numSerieString.isEmpty() || technicien.isEmpty() || dateMaintenance == null || typeMaintenance == null) {
            showAlert("Erreur", "Veuillez remplir tous les champs.");
            return;  // Exit the method early if any fields are empty
        }

        // Try to parse numSerie as an integer
        int numSerie;
        try {
            numSerie = Integer.parseInt(numSerieString);  // Parse the string to int
        } catch (NumberFormatException e) {
            showAlert("Erreur", "Numéro de série invalide.");
            return;  // Exit the method if numSerie is not a valid integer
        }

        // Display the planned maintenance details (only showing the text)
        String details = "Maintenance Planifiée :\n" +
                "Nom de l'équipement: " + nom +
                "\nMarque: " + marque +
                "\nNuméro de série: " + numSerie +
                "\nTechnicien: " + technicien +
                "\nDate de maintenance: " + dateMaintenance +
                "\nType de maintenance: " + typeMaintenance +
                "\nEtat avant maintenance: " + etatAvant +
                "\nEtat après maintenance: " + etatApres;
        showAlert("Maintenance Planifiée", details);
    }

    // Action to modify maintenance
    @FXML
    public void modifierMaintenance(ActionEvent event) {
        // Get the new values from the form
        String nouveauTypeMaintenance = typeMaintenanceCombo.getValue();
        Date nouvelleDate = java.sql.Date.valueOf(dateMaintenancePicker.getValue());
        String nouvelEtatAvant = etatAvantArea.getText();
        String nouvelEtatApres = etatApresArea.getText();

        if (nouveauTypeMaintenance == null || nouvelleDate == null || nouvelEtatAvant.isEmpty() || nouvelEtatApres.isEmpty()) {
            showAlert("Erreur", "Veuillez remplir tous les champs pour modifier.");
            return;
        }

        // Display the modified maintenance details (only showing the text)
        String details = "Maintenance Modifiée :\n" +
                "Type de maintenance: " + nouveauTypeMaintenance +
                "\nDate de maintenance: " + nouvelleDate +
                "\nEtat avant maintenance: " + nouvelEtatAvant +
                "\nEtat après maintenance: " + nouvelEtatApres;
        showAlert("Maintenance Modifiée", details);
    }

    // Action to generate a maintenance report
    @FXML
    public void genererRapport(ActionEvent event) {
        // Generate the report message (only showing the text)
        String rapport = "Rapport de Maintenance:\n" +
                "Nom de l'équipement: " + equipementField.getText() +
                "\nMarque: " + marqueField.getText() +
                "\nNuméro de série: " + numSerieField.getText() +
                "\nTechnicien: " + technicienField.getText() +
                "\nDate de maintenance: " + dateMaintenancePicker.getValue() +
                "\nType de maintenance: " + typeMaintenanceCombo.getValue() +
                "\nEtat avant maintenance: " + etatAvantArea.getText() +
                "\nEtat après maintenance: " + etatApresArea.getText();

        // Show the report
        showAlert("Rapport Généré", rapport);
    }

    // Function to display an alert
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
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
