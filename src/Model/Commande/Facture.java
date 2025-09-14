/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Commande;
import java.util.Date;
import java.time.LocalDate;
import java.util.*;
/**
 *
 * @author Extreme PC
 */
import java.time.LocalDate;

public record Facture(int numero, LocalDate DateFacture, double montantTotal, double montantPaye, Fournisseur fournisseur) {

    // Méthode pour afficher la facture
    public void afficherFacture() {
        System.out.println("Facture N°" + numero);
        System.out.println("Date de Facture : " + DateFacture);
        System.out.println("Montant Total : " + montantTotal);
        System.out.println("Montant Payé : " + montantPaye);
        System.out.println("Fournisseur : " + fournisseur.getNom());  // Afficher le nom du fournisseur
        System.out.println("Téléphone du fournisseur : " + fournisseur.getTelephone());  // Afficher le téléphone du fournisseur
    }

    public double calculerResteAPayer() {
        return montantTotal - montantPaye;
    }

    public void genererRecuPaiement() {
        System.out.println("Reçu de paiement généré : ");
        System.out.println("Facture N°" + numero);
        System.out.println("Montant payé : " + montantPaye);
        System.out.println("Date de paiement : " + LocalDate.now());
    }

    public boolean estEntierementPaye() {
        return montantTotal - montantPaye == 0;
    }
}
