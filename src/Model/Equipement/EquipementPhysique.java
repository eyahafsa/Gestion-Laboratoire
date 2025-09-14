/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Equipement;
import java.util.Date;

/**
 *
 * @author Extreme PC
 */
public final class EquipementPhysique extends Equipement implements EquipementVerifier {
    private double niveauPrecision; // Niveau de précision de l'équipement (de 100% à 0%)
    private static final double SEUIL_MIN_PRECISION = 50.0; // Seuil minimum avant besoin de calibration

    public EquipementPhysique(String nom, String marque, int numeroSerie, Date dateAchat, String etat) {
        super(nom, marque, numeroSerie, dateAchat, etat);
        this.niveauPrecision = 100.0; // Commence à 100% de précision
    }

    // Méthode pour utiliser l'équipement et dégrader la précision
    public void utiliserEquipement (){
        niveauPrecision -= 5.0; // Réduit la précision de 5% à chaque utilisation
        System.out.println("L'équipement a été utilisé. Niveau de précision actuel : " + niveauPrecision + "%");

        if (niveauPrecision < SEUIL_MIN_PRECISION) {
            System.out.println("Attention : Le niveau de précision est bas. Une calibration est nécessaire.");
        }
    }

    public static double getSeuilMinPrecision() {
    return SEUIL_MIN_PRECISION;
}
   public double getNiveauPrecision() {
        return niveauPrecision;
    }
    public void setNiveauPrecision(double niveauPrecision) {
        this.niveauPrecision = niveauPrecision;
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Niveau de précision actuel : " + niveauPrecision + "%");
    }
    @Override
    public boolean verifierEquipementEndommage(int niveauPrecision) {
        // L'équipement est considéré comme endommagé si son niveau de précision est inférieur au seuil
        return niveauPrecision < SEUIL_MIN_PRECISION;
    }
}


  