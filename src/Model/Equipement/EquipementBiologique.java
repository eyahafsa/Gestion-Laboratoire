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
public final class EquipementBiologique extends Equipement implements EquipementVerifier{
      private Double TemperatureStockage;
      public EquipementBiologique(String Nom,String Marque,int NumSerie,Date date,String Etat,Double Temp) {
      super(Nom,Marque,NumSerie,date,Etat);
      this.TemperatureStockage=Temp;
      
   }
   @Override
public boolean verifierEquipementEndommage(int val) {
    // Logique pour vérifier si un réactif biologique est endommagé

    final int TEMP_MIN = 0;  // Température minimale acceptable en °C (par exemple, réactifs congelés)
    final int TEMP_MAX = 8;  // Température maximale acceptable en °C (par exemple, réactifs réfrigérés)

    // Si la température de stockage est en dehors des limites définies pour un réactif biologique, l'équipement est endommagé
    return val < TEMP_MIN || val > TEMP_MAX;
}
 public Double getTemperatureStockage() {
        return TemperatureStockage;
    }
  

 @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Température de stockage : " + TemperatureStockage + "°C");
    }
   
    public String getNom() {
        return super.getNom();
    }
    
    public void setNom(String Nom) {
        super.setNom(Nom);
    }

    public String getMarque() {
        return super.getMarque();
    }
    
    public String getEtat() {
        return super.getEtat();
    }

    public void setEtat(String Etat) {
        super.setEtat(Etat);
    }
}
