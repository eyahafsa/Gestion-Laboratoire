package Controller.CommandeEquipement;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FactureFxmlController implements Initializable {

   
    @FXML
    private TextField factureNumeroField; // Champ de texte pour le numéro de la facture
    @FXML
    private TextField factureDateField; // Champ de texte pour la date de la facture
    @FXML
    private TextField montantTotalField; // Champ de texte pour le montant total
    @FXML
    private TextField montantPayeField; // Champ de texte pour le montant payé
    @FXML
    private TextField fournisseurNomField; // Champ de texte pour le nom du fournisseur
    @FXML
    private TextField fournisseurTelField; // Champ de texte pour le téléphone du fournisseur
    
     @FXML
    private Button generateReceiptBtn; // Bouton défini dans le fichier FXML
    @FXML
    private GridPane factureGrid;
    @FXML
    private Text title;
    @FXML
    private Button back;
 private Scene previousScene; // Stocke la scène précédente

    public void setPreviousScene(Scene scene) {
        this.previousScene = scene; // Permet à Page1 de transmettre la scène précédente
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the fields with default values (optional)
       if (factureNumeroField != null && !factureNumeroField.textProperty().isBound()) {
        factureNumeroField.setText("1");
      factureNumeroField.setEditable(true);
    factureDateField.setEditable(true);
    montantTotalField.setEditable(true);
    montantPayeField.setEditable(true);
    fournisseurNomField.setEditable(true);
    fournisseurTelField.setEditable(true);
    

    // Ajouter des valeurs par défaut (optionnel)
    factureNumeroField.setText("");
    factureDateField.setText("0000-00-00");
    montantTotalField.setText("0.0");
    montantPayeField.setText("0.0");
    fournisseurNomField.setText("");
    fournisseurTelField.setText("00000000");
    
    }
    }
    // Method called when the "Générer Reçu" button is clicked
    @FXML
    public void click() {
        // Get the data from the text fields
       String factureNumero = factureNumeroField.getText();
       String factureDate = factureDateField.getText();
       String montantTotalText = montantTotalField.getText();
       String montantPayeText = montantPayeField.getText();
       String fournisseurNom = fournisseurNomField.getText();
       String fournisseurTel = fournisseurTelField.getText();

    // Calculate Reste à Payer
    double montantTotal = 0.0;
    double montantPaye = 0.0;
    double resteAPayer = 0.0;

    try {
        montantTotal = Double.parseDouble(montantTotalText);
        montantPaye = Double.parseDouble(montantPayeText);

        // Calculate Reste à Payer (Montant Total - Montant Payé)
        resteAPayer = montantTotal - montantPaye;
    } catch (NumberFormatException e) {
        // Handle the case where the text is not a valid number
        System.out.println("Erreur lors de la conversion des montants : " + e.getMessage());
    }

    // Call the method to generate the receipt with the gathered data and the calculated Reste à Payer
    genererRecuPaiement(factureNumero, factureDate, montantTotal, montantPaye, fournisseurNom, fournisseurTel, resteAPayer);
}

// Method to generate the payment receipt with the entered data
public void genererRecuPaiement(String factureNumero, String factureDate, double montantTotal, double montantPaye, String fournisseurNom, String fournisseurTel, double resteAPayer) {
    // Display the entered data in the console (for debugging)
    System.out.println("Reçu de paiement généré :");
    System.out.println("Facture N°" + factureNumero);
    System.out.println("Date de Facture : " + factureDate);
    System.out.println("Montant Total : " + montantTotal);
    System.out.println("Montant Payé : " + montantPaye);
    System.out.println("Fournisseur : " + fournisseurNom);
    System.out.println("Téléphone Fournisseur : " + fournisseurTel);
    System.out.println("Reste à Payer : " + resteAPayer);

    // Create an alert to display the entered information
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Reçu généré");
    alert.setHeaderText("Votre reçu de paiement a été généré !");
    alert.setContentText("Reste à Payer : " + resteAPayer);

    // Display the alert
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