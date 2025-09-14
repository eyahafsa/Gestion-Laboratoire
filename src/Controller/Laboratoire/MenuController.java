/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Laboratoire;

import Controller.AnalyseTechnique.AnalyseController;
import Controller.AnalyseTechnique.PrelevementController;
import Controller.AnalyseTechnique.ResultatController;
import Controller.AnalyseTechnique.TechnicienController;
import Controller.CommandeEquipement.CommandeFxmlController;
import Controller.CommandeEquipement.EquipementFxmlController;
import Controller.CommandeEquipement.FactureFxmlController;
import Controller.CommandeEquipement.FournisseurController;
import Controller.CommandeEquipement.MaintenanceFxmlController;
import Controller.CommandeEquipement.StockFxmlController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class MenuController implements Initializable {

    @FXML
    private HBox hboxPat;
    @FXML
    private HBox hboxRv;
    @FXML
    private HBox hboxLabo;
    @FXML
    private HBox hboxAnalyse;
    @FXML
    private Label idFact;
    @FXML
    private HBox hboxEquip;
    @FXML
    private HBox hboxStock;
    @FXML
    private HBox hboxCmd;
    @FXML
    private HBox hboxPrev;
    @FXML
    private HBox hboxRes;
    @FXML
    private Label idStat;
    @FXML
    private Label idMain;
    @FXML
    private Label idTec;
    @FXML
    private Label idFour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hboxPat.setOnMouseClicked(this::onHBoxClicked);
        hboxRv.setOnMouseClicked(this::onHBoxClickedRv);
        hboxLabo.setOnMouseClicked(this::onHBoxClickedLabo);
        hboxAnalyse.setOnMouseClicked(this::onHBoxClickedAnalyse);
        hboxEquip.setOnMouseClicked(this::onHBoxClickedEquip);
        hboxStock.setOnMouseClicked(this::onHBoxClickedStck);
        hboxCmd.setOnMouseClicked(this::onHBoxClickedCmd);
        hboxPrev.setOnMouseClicked(this::onHBoxClickedPrel);
        hboxRes.setOnMouseClicked(this::onHBoxClickedRes);
    }    
    private void onHBoxClicked(MouseEvent event) {
        try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Labo/GestionPatient.fxml"));
            Parent root = loader.load();
            GestionPatientController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            // Afficher l'interface
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Gestion des patients");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onHBoxClickedRv(MouseEvent event) {
        try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Labo/GestionRDV.fxml"));
            Parent root = loader.load();

           GestionRDVController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Gestion des rendez-vous");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onHBoxClickedLabo(MouseEvent event) {
        try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Labo/GestPersonnelLabo.fxml"));
            Parent root = loader.load();
            
            GestPersonnelLaboController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Gestion des personnels");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onHBoxClickedAnalyse(MouseEvent event) {
         try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/AnalyseTechnique/Analyse.fxml"));
            Parent root = loader.load();

            AnalyseController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Gestion des analyses");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void afficherFactures(MouseEvent event) {
        try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/CommandeEquipement/FactureFxml.fxml"));
            Parent root = loader.load();

           FactureFxmlController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Facture");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onHBoxClickedEquip(MouseEvent event) {
       try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/CommandeEquipement/EquipementFxml.fxml"));
            Parent root = loader.load();

            EquipementFxmlController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Gestion des équipements");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onHBoxClickedStck(MouseEvent event) {
        try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/CommandeEquipement/StockFxml.fxml"));
            Parent root = loader.load();

            StockFxmlController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Gestion des stocks");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }}

    private void onHBoxClickedCmd(MouseEvent event) {
        try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/CommandeEquipement/CommandeFxml.fxml"));
            Parent root = loader.load();

            CommandeFxmlController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Gestion des commandes");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }}

    private void onHBoxClickedPrel(MouseEvent event) {
       try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/AnalyseTechnique/Prelevement.fxml"));
            Parent root = loader.load();

            PrelevementController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Gestion des prélèvements");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onHBoxClickedRes(MouseEvent event) {
       try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/AnalyseTechnique/Resultat.fxml"));
            Parent root = loader.load();

            ResultatController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Gestion des résultats");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void afficherStat(MouseEvent event) {
         try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Labo/statistique.fxml"));
            Parent root = loader.load();

            StatistiqueController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Statistique");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void afficherMain(MouseEvent event) {
        try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/CommandeEquipement/MaintenanceFxml.fxml"));
            Parent root = loader.load();

            MaintenanceFxmlController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("GMaintenance");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void afficherTech(MouseEvent event) {
        try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/AnalyseTechnique/Technicien.fxml"));
            Parent root = loader.load();

            TechnicienController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("Techniciens");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void afficherFour(MouseEvent event) {
        try {
            // Chargez la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/CommandeEquipement/Fournisseur.fxml"));
            Parent root = loader.load();

            FournisseurController ajouterController=loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ajouterController.setPreviousScene(currentStage.getScene());
            Stage stage = currentStage;
            stage.setScene(new Scene(root));
            stage.setTitle("GMaintenance");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
