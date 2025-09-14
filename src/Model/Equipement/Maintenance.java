/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Equipement;
import java.util.Date;
import Model.Equipement.EquipementBiologique;
/**
 *
 * @author Extreme PC
 */

public class Maintenance {
    private Equipement equipement;
    private String technicien;
    private Date dateMaintenance;
    private String typeMaintenance; // corrective ou préventive
    private String etatAvantMaintenance;
    private String etatApresMaintenance;
    private String rapportMaintenance;

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public String getTechnicien() {
        return technicien;
    }

    public void setTechnicien(String technicien) {
        this.technicien = technicien;
    }

    public Date getDateMaintenance() {
        return dateMaintenance;
    }

    public void setDateMaintenance(Date dateMaintenance) {
        this.dateMaintenance = dateMaintenance;
    }

    public String getTypeMaintenance() {
        return typeMaintenance;
    }

    public void setTypeMaintenance(String typeMaintenance) {
        this.typeMaintenance = typeMaintenance;
    }

    public String getEtatAvantMaintenance() {
        return etatAvantMaintenance;
    }

    public void setEtatAvantMaintenance(String etatAvantMaintenance) {
        this.etatAvantMaintenance = etatAvantMaintenance;
    }

    public String getEtatApresMaintenance() {
        return etatApresMaintenance;
    }

    public void setEtatApresMaintenance(String etatApresMaintenance) {
        this.etatApresMaintenance = etatApresMaintenance;
    }

    public String getRapportMaintenance() {
        return rapportMaintenance;
    }

    public void setRapportMaintenance(String rapportMaintenance) {
        this.rapportMaintenance = rapportMaintenance;
    }

    // Méthode pour planifier la maintenance
    public void planifierMaintenance(Equipement equipement, Date dateMaintenance, String typeMaintenance) {
        System.out.println("La maintenance de l'équipement " + equipement.getNom() +
                " est planifiée pour le " + dateMaintenance + " et il s'agit d'une maintenance " + typeMaintenance);
    }

    // Méthode pour modifier la maintenance
    public void modifierMaintenance(Date nouvelleDate, String nouveauTypeMaintenance) {
        this.dateMaintenance = nouvelleDate;
        this.typeMaintenance = nouveauTypeMaintenance;
    }

    // Méthode pour afficher les détails de la maintenance
    public void afficherMaintenance() {
        System.out.println("Équipement: " + equipement.getNom());
        System.out.println("Technicien: " + technicien);
        System.out.println("Date de maintenance: " + dateMaintenance);
        System.out.println("Type de maintenance: " + typeMaintenance);
        System.out.println("État avant maintenance: " + etatAvantMaintenance);
        System.out.println("État après maintenance: " + etatApresMaintenance);
    }

    // Méthode pour générer le rapport de maintenance
    public String genererRapportMaintenance() {
        return "Rapport de maintenance généré : " + rapportMaintenance;
    }

    // Méthode de maintenance générale qui vérifie si une maintenance est nécessaire
    public void effectuerMaintenance(Equipement equipement, double critere) {
        if (equipement == null) {
            System.out.println("Équipement invalide.");
            return;
        }

        System.out.println("Démarrage de la maintenance pour l'équipement : " + equipement.getNom());

        // Traitement spécifique en fonction du type d'équipement
        if (equipement instanceof EquipementBiologique) {
            traiterEquipementBiologique((EquipementBiologique) equipement, critere);
        } else if (equipement instanceof EquipementPhysique) {
            traiterEquipementPhysique((EquipementPhysique) equipement, critere);
        } else {
            System.out.println("Type d'équipement non pris en charge pour la maintenance.");
        }
    }

    // Traiter un équipement biologique
    private void traiterEquipementBiologique(EquipementBiologique equipementBio, double critereTemperature) {
        if (equipementBio.getTemperatureStockage() < critereTemperature) {
            System.out.println("Maintenance requise pour l'équipement biologique. Température trop basse.");
        } else {
            System.out.println("L'équipement biologique est en bon état.");
        }
    }

    // Traiter un équipement physique
    private void traiterEquipementPhysique(EquipementPhysique equipementPhy, double criterePrecision) {
        if (equipementPhy.getNiveauPrecision() < criterePrecision) {
            System.out.println("Maintenance requise pour l'équipement physique. Précision trop basse.");
        } else {
            System.out.println("L'équipement physique est en bon état.");
        }
    }
}
