/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Commande;
/**
 *
 * @author Extreme PC
 */
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;


public class Commande {
    private int idCommande;
    private Map<String, Double> materiels; // Clé = nom de l'article, valeur = prix
    private LocalDate dateCommande;
    private double montant;
    private boolean isValidated;  
    private boolean isCanceled;  
    // Constructeur
    public Commande(int idCommande, Map<String, Double> materiels, LocalDate dateCommande) {
        this.idCommande = idCommande;
        this.materiels = materiels;
        this.dateCommande = dateCommande;
        calculerMontant();//appel de calcul de methodes dans le contructeur
    }

    // Méthode pour calculer le montant total de la commande
    public void calculerMontant() {
        double total = 0;
        for (Map.Entry<String, Double> entry : materiels.entrySet()) {
            total += entry.getValue();  // Somme des prix des articles
        }
        this.montant = total;
    }

    // Méthode pour afficher la commande
    public void afficherCommande() {
        System.out.println("Commande ID: " + idCommande);
        System.out.println("Date de commande: " + dateCommande);
        for (Map.Entry<String, Double> entry : materiels.entrySet()) {
            System.out.println("Article: " + entry.getKey() + ", Prix: " + entry.getValue());
        }
        System.out.println("Montant total: " + montant);
 
    }public boolean modifierMateriel(String nomMateriel, double nouveauPrix) {
    if (materiels.containsKey(nomMateriel)) {
        materiels.put(nomMateriel, nouveauPrix);
        return true;
    }
    return false;
}
  
    
      public void validerCommande() throws CommandeInvalideException {
        // Vérifier si la commande contient des articles
        if (materiels.isEmpty()) {
            throw new CommandeInvalideException("La commande doit contenir au moins un article.");
        }

        // Vérifier si le montant est valide (supérieur à 0)
        if (montant <= 0) {
            throw new CommandeInvalideException("Le montant total de la commande doit être supérieur à 0.");
        }

        // Vérifier si la date de commande n'est pas dans le passé
        if (dateCommande.isBefore(LocalDate.now())) {
            throw new CommandeInvalideException("La date de la commande ne peut pas être dans le passé.");
        }
        
        // Si toutes les conditions sont remplies, la commande est validée
        isValidated = true;
        System.out.println("Commande validée avec succès !");
    }

    // Méthode pour annuler une commande
   public void annulerCommande() throws CommandeNonAnnulableException {
    if (isCanceled) {
        throw new CommandeNonAnnulableException("La commande a déjà été annulée.");
        // Stopper l'exécution ici
    }

    if (isValidated) {
        throw new CommandeNonAnnulableException("Une commande validée ne peut pas être annulée.");
        // Stopper l'exécution ici
    }

    // Annuler la commande si elle n'est ni validée ni déjà annulée
    materiels.clear();
    isCanceled = true;
    System.out.println("Commande annulée avec succès !");
}
public void addMateriel(String name, double price) {
    materiels.put(name, price);
    calculateMontant();
}

public void removeMateriel(String name) {
    materiels.remove(name);
    calculateMontant();
}

private void calculateMontant() {
    montant = materiels.values().stream().mapToDouble(Double::doubleValue).sum();
}




     public double getMontant(){
        return montant;
    }
     public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    // Getter et Setter pour materiels
    public Map<String, Double> getMateriels() {
        return materiels;
    }

    public void setMateriels(Map<String, Double> materiels) {
        this.materiels = materiels;
    }

    // Getter et Setter pour dateCommande
    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

  

    public void setMontant(double montant) {
        this.montant = montant;
    }
}


