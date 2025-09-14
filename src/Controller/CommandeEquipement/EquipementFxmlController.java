package Controller.CommandeEquipement;

import Model.Equipement.Equipement;
import Model.Equipement.EquipementBiologique;
import Model.Equipement.EquipementPhysique;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class EquipementFxmlController {
    
    @FXML
    private TextField nomField, marqueField, numSerieField, temperatureField, precisionField;

    @FXML
    private DatePicker dateAchatField;

    @FXML
    private ComboBox<String> etatCombo;
    @FXML
    private Label temperatureLabel, precisionLabel;
    @FXML
    private Button back;
      private Scene previousScene; // Stocke la scène précédente
    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }
   public void initialize() {
        // Initialize ComboBox items
        ObservableList<String> etatOptions = FXCollections.observableArrayList("Biologique", "Physique");
        etatCombo.setItems(etatOptions);
    }

    @FXML
    private void updateEquipementType() {
        String type = etatCombo.getValue();
        boolean isBiologique = "Biologique".equals(type);
        boolean isPhysique = "Physique".equals(type);

        temperatureLabel.setVisible(isBiologique);
        temperatureField.setVisible(isBiologique);

        precisionLabel.setVisible(isPhysique);
        precisionField.setVisible(isPhysique);
    }

    @FXML
    private void ajouterEquipement() {
        try {
            // Récupération des valeurs
            String nom = nomField.getText();
            String marque = marqueField.getText();
            int numSerie = Integer.parseInt(numSerieField.getText());
            LocalDate dateAchat = dateAchatField.getValue();
            String type = etatCombo.getValue();

            if (nom.isEmpty() || marque.isEmpty() || type == null || dateAchat == null) {
                throw new IllegalArgumentException("Veuillez remplir tous les champs obligatoires.");
            }

            Equipement equipement;
            if ("Biologique".equals(type)) {
                double temperature = Double.parseDouble(temperatureField.getText());
                equipement = new EquipementBiologique(nom, marque, numSerie, java.sql.Date.valueOf(dateAchat), type, temperature);
            } else if ("Physique".equals(type)) {
                String precision = precisionField.getText();
                equipement = new EquipementPhysique(nom, marque, numSerie, java.sql.Date.valueOf(dateAchat), type);
            } else {
                throw new IllegalArgumentException("Type d'équipement invalide.");
            }

            System.out.println("Équipement ajouté avec succès :");
            equipement.afficherDetails();
        
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de l'équipement : " + e.getMessage());
        }
    }
    @FXML
private void afficherDetails() {
    try {
        // Retrieve data from the fields
        String nom = nomField.getText();
        String marque = marqueField.getText();
        String numSerie = numSerieField.getText();
        String etat = etatCombo.getValue();
        Date dateAchat = (dateAchatField.getValue() != null) ? java.sql.Date.valueOf(dateAchatField.getValue()) : null;

        // Validate required fields
        if (nom.isEmpty() || marque.isEmpty() || numSerie.isEmpty() || etat == null || dateAchat == null) {
            throw new IllegalArgumentException("Veuillez remplir tous les champs obligatoires.");
        }

        // Display specific details based on the type of equipment
        String details;
        if ("Biologique".equals(etat)) {
            if (temperatureField.getText().isEmpty()) {
                throw new IllegalArgumentException("Veuillez remplir la température pour l'équipement biologique.");
            }
            double temperature = Double.parseDouble(temperatureField.getText());
            details = String.format(
                "Détails de l'Équipement:\n- Nom: %s\n- Marque: %s\n- Numéro de Série: %s\n- Date d'Achat: %s\n- État: %s\n- Température de Stockage: %.2f°C",
                nom, marque, numSerie, dateAchat, etat, temperature
            );
        } else if ("Physique".equals(etat)) {
            if (precisionField.getText().isEmpty()) {
                throw new IllegalArgumentException("Veuillez remplir le niveau de précision pour l'équipement physique.");
            }
            String precision = precisionField.getText();
            details = String.format(
                "Détails de l'Équipement:\n- Nom: %s\n- Marque: %s\n- Numéro de Série: %s\n- Date d'Achat: %s\n- État: %s\n- Niveau de Précision: %s",
                nom, marque, numSerie, dateAchat, etat, precision
            );
        } else {
            details = "Aucun détail disponible pour ce type d'équipement.";
        }

        // Output the details to the console (or integrate with a display method in your GUI)
        System.out.println(details);

    } catch (NumberFormatException e) {
        System.out.println("Erreur: Le numéro de série ou la température doit être un nombre valide.");
    } catch (IllegalArgumentException e) {
        System.out.println("Erreur: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Une erreur inattendue s'est produite: " + e.getMessage());
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
