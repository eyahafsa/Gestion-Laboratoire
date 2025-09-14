/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Equipement;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Extreme PC
 */
import java.util.List;
import java.util.stream.Collectors;

public class Stock {
    private List<Equipement> equipementsDisponibles;
    public Stock() {
        equipementsDisponibles = new ArrayList<>();  // Initialisation de la liste ici
    }
    // Méthode pour ajouter un équipement
    public void ajouterEquipement(Equipement equipement) {
        equipementsDisponibles.add(equipement);
    }

    // Filtrer les équipements en stock selon leur type (par exemple, physiques)
    public List<Equipement> filtrerEquipementsPhysiques() {
        return equipementsDisponibles.stream()
                                      .filter(e -> e instanceof EquipementPhysique)
                                      .collect(Collectors.toList());
    }

    // Filtrer les équipements en stock selon leur type (biologiques)
    public List<Equipement> filtrerEquipementsBiologiques() {
        return equipementsDisponibles.stream()
                                      .filter(e -> e instanceof EquipementBiologique)
                                      .collect(Collectors.toList());
    }

    // Trouver un équipement spécifique par son nom
    
    public Equipement trouverEquipementParNom(String nom) {
        return equipementsDisponibles.stream()
                                      .filter(e -> e.getNom().equals(nom))
                                      .findFirst()
                                      .orElse(null);
    }

    // Calculer la quantité totale d'équipements
    public int calculerQuantiteTotale() {
        return equipementsDisponibles.size();
    }

    // Méthode pour afficher les équipements physiques en stock
    public void afficherEquipementsPhysiques() {
        List<Equipement> equipementsPhysiques = filtrerEquipementsPhysiques();
        System.out.println("Équipements physiques dans le stock : ");
        for (Equipement e : equipementsPhysiques) {
            System.out.println(e.getNom());
        }
    }

    // Méthode pour afficher les équipements biologiques en stock
    public void afficherEquipementsBiologiques() {
        List<Equipement> equipementsBiologiques = filtrerEquipementsBiologiques();
        System.out.println("\nÉquipements biologiques dans le stock : ");
        for (Equipement e : equipementsBiologiques) {
            System.out.println(e.getNom());
        }
    }

    // Méthode pour rechercher un équipement par son nom et l'afficher
    public void afficherEquipementParNom(String nom) {
        Equipement equipementTrouve = trouverEquipementParNom(nom);
        if (equipementTrouve != null) {
            System.out.println("\nÉquipement trouvé : " + equipementTrouve.getNom());
        } else {
            System.out.println("\nAucun équipement trouvé avec ce nom.");
        }
    }

    // Méthode pour afficher la quantité totale d'équipements
    public void afficherQuantiteTotale() {
        int quantiteTotale = calculerQuantiteTotale();
        System.out.println("\nQuantité totale d'équipements en stock : " + quantiteTotale);
    }

    // Méthode pour tester tout le processus
    public void testerStock() {
        // Afficher les équipements physiques
        afficherEquipementsPhysiques();

        // Afficher les équipements biologiques
        afficherEquipementsBiologiques();

        // Afficher un équipement par nom
        afficherEquipementParNom("Centrifugeuse");

        // Afficher la quantité totale d'équipements
        afficherQuantiteTotale();
    }
}


