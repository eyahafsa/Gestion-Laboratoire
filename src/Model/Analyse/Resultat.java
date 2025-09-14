/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Analyse;

/**
 *
 * @author ayach
 */
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
public record Resultat(Analyse analyse, String resultat, Date dateResultat) {

    private static Map<Analyse, String> resultatMap = new HashMap<>();

   // Méthode pour vérifier si le résultat est en retard
   // public boolean estEnRetard() {
        //Date dateResultatCalculée = analyse.calculerDateResultat(); // Récupérer la date de résultat calculée
       // Date dateActuelle = new Date();
      //  return dateResultatCalculée.before(dateActuelle); // Si la date de résultat calculée est avant la date actuelle, c'est en retard
    

    // Méthode pour envoyer le résultat
    /*public void envoyerResultat() {
        if (estEnRetard()) {
            System.out.println("Le résultat de l'analyse pour l'analyse " + analyse.getId()+ " est en retard !");
             System.out.println("Désolé, il semble que nous n'ayons pas pu vous fournir les résultats à temps.");
        
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Le résultat de l'analyse pour l'analyse " + analyse.getId() + " est prêt. Date de résultat: " 
                + sdf.format(dateResultat) + "\nRésultat: " + resultat);
          System.out.println("Merci de consulter vos résultats sur votre compte patient.");
        }
    }*/
    
    // Enregistrer le résultat dans le Map
    
    public static void enregistrerResultat(Analyse analyse, String resultat) {
        resultatMap.put(analyse, resultat);
    }

    // Méthode pour afficher tous les résultats enregistrés
    public static void afficherResultats() {
        for (Map.Entry<Analyse, String> entry : resultatMap.entrySet()) {
            Analyse analyse = entry.getKey();
            String resultat = entry.getValue();
            System.out.println("Analyse: " + analyse.getId()+ "\nRésultat: " + resultat);
        }
    }
}
    
 