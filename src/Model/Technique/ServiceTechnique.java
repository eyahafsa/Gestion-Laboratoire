/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Technique;

/**
 *
 * @author ayach
 */
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class ServiceTechnique {

    private String nomDuService;
    private List<Technicien> listeDesTechniciens;
    private String responsable;

    public ServiceTechnique(String nomDuService, List<Technicien> listeDesTechniciens, String responsable) {
        this.nomDuService = nomDuService;
        this.listeDesTechniciens = listeDesTechniciens;
        this.responsable = responsable;
    }

    // Getters and Setters
    public String getNomDuService() {
        return nomDuService;
    }

    public void setNomDuService(String nomDuService) {
        this.nomDuService = nomDuService;
    }

    public List<Technicien> getListeDesTechniciens() {
        return listeDesTechniciens;
    }

    public void setListeDesTechniciens(List<Technicien> listeDesTechniciens) {
        this.listeDesTechniciens = listeDesTechniciens;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    // Method to add a technician to the list
    public boolean chercherSpecialite(String specialite) {
        for (Technicien tech : listeDesTechniciens) {
            if (tech.getSpecialite().equals(specialite)) {
                return true; // Spécialité trouvée
            }
        }
        return false; // Spécialité non trouvée
    }

    public void ajouterTechnicien(Technicien technicien) {
        try {
            if (chercherSpecialite(technicien.getSpecialite())) {
                throw new SpecialiteException("Un technicien avec la spécialité existe déjà : " + technicien.getSpecialite());
            }
            listeDesTechniciens.add(technicien); // Ajouter seulement si la spécialité est unique
            System.out.println("Technicien ajouté avec succès.");
        } catch (SpecialiteException e) {
            System.out.println("Impossible d'ajouter le technicien : " + e.getMessage());
        }
    }

    public int nbrTechniciens() {
        return listeDesTechniciens.size();
    }

    // Méthode qui retourne une lambda pour vérifier une spécialité
    public static Predicate<Technicien> verifierSpecialite(String specialite) {
        return technicien -> technicien.getSpecialite().equals(specialite);
    }

// Grouper les techniciens par spécialité
    public void regrouperTechSpecialité() {
        Map<String, Long> nombreParSpecialite = listeDesTechniciens.stream()
                .collect(Collectors.groupingBy(Technicien::getSpecialite, Collectors.counting()));

        nombreParSpecialite.forEach((specialite, count)
                -> System.out.println("Spécialité: " + specialite + ", Nombre: " + count));
    }

    @Override
    public String toString() {
        return "ServiceTechnique{"
                + "nomDuService='" + nomDuService + '\''
                + ", listeDesTechniciens=" + listeDesTechniciens
                + ", responsable='" + responsable + '\''
                + '}';
    }
}
