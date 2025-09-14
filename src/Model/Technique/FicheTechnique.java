/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Technique;

/**
 *
 * @author ayach
 */
public class FicheTechnique {
    private String equipement;
    private String instruction;
    private String entretien;

    public FicheTechnique(String equipement, String instruction, String entretien) {
        this.equipement = equipement;
        this.instruction = instruction;
        this.entretien = entretien;
    }

    // Getters and Setters
    public String getEquipement() { return equipement; }
    public void setEquipement(String equipement) { this.equipement = equipement; }

    public String getInstruction() { return instruction; }
    public void setInstruction(String instruction) { this.instruction = instruction; }

    public String getEntretien() { return entretien; }
    public void setEntretien(String entretien) { this.entretien = entretien; }

    @Override
    public String toString() {
        return "FicheTechnique{" +
               "equipement='" + equipement + '\'' +
               ", instruction='" + instruction + '\'' +
               ", entretien='" + entretien + '\'' +
               '}';
    } 
}
