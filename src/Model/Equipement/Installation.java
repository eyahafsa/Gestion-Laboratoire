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
public class Installation {
private Equipement equipement;
private String technicien;
private Date dateInstallation;

  public Installation(Equipement equipement, String technicien, Date dateInstallation) {
        this.equipement = equipement;
        this.technicien = technicien;
        this.dateInstallation = dateInstallation;
    }

public void planifierInstallation(){
    System.out.println("l'Installation est planifiée pour l'équipement : " + equipement.getNom() + " par " + technicien + " le " + dateInstallation);
}


public void modifierInstallation(Date nouvelleDate, String nouveauTechnicien) {
    if (nouvelleDate != null) {
        this.dateInstallation = nouvelleDate;
        System.out.println("Installation modifiée pour l'équipement : " + equipement.getNom() + 
                           " nouvelle date : " + dateInstallation);
    }
    
    if (nouveauTechnicien != null && !nouveauTechnicien.isEmpty()) {
        this.technicien = nouveauTechnicien;
        System.out.println("Installation modifiée, le nouveau technicien est : " + technicien);
    }
}

public void afficherInstallation(){
System.out.println("Détails de l'installation");
System.out.println("l'équipement :"+equipement.getNom());
System.out.println("le technicien :"+technicien);
System.out.println("la date de l'installation :"+dateInstallation);
}
// Vérifie la conformité des installations.
public boolean verifierConformiteInstallation( ){
  boolean conforme = equipement.estConforme(); 
        if (conforme) {
            System.out.println("L'installation de l'équipement est conforme.");
        } else {
            System.out.println("L'installation de l'équipement n'est pas conforme.");
        }
        return conforme;
}

public void genererRapportInstallation()
{
      System.out.println("Rapport d'installation généré pour l'équipement : " + equipement.getNom());
        System.out.println("Technicien : " + technicien);
        System.out.println("Date d'installation : " + dateInstallation);
        verifierConformiteInstallation();
          
    
}// Génère un rapport après l’installation.

}
