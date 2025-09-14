/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Analyse;

/**
 *
 * @author ayach
 */
import java.util.Date ;
public  final class  AnalyseSanguine  extends Analyse {

    private TypeSang  typeSang;
    private float globulesRouges;
    private float globulesBlancs;
    private float tauxHemoglobine;
    private float tauxPlaquettes;
    private float cholesterol; 
    public AnalyseSanguine ( int idprelevement,Date dateResultat,Date dateAnalyse, double p ,TypeSang typeSang, float globulesRouges, float globulesBlancs ,float tauxHemoglobine, float tauxPlaquettes, float cholesterol)
    {
        super (   idprelevement,dateResultat,dateAnalyse,p);
        this.typeSang = typeSang;
        this.globulesRouges = globulesRouges;
        this.globulesBlancs = globulesBlancs;
        this.tauxHemoglobine = tauxHemoglobine;
        this.tauxPlaquettes = tauxPlaquettes;
        this.cholesterol = cholesterol;
    }
    // Getter et Setter pour globulesRouges
    public float getGlobulesRouges() {
        return globulesRouges;
    }

    public void setGlobulesRouges(float globulesRouges)  throws AnalyseException {
         if (globulesRouges < 0) {
        throw new AnalyseException ("globules rouges", globulesRouges);
    }
    this.globulesRouges = globulesRouges;
    }

    // Getter et Setter pour globulesBlancs
    public float getGlobulesBlancs() {
        return globulesBlancs;
    }

    public void setGlobulesBlancs(float globulesBlancs) {
        this.globulesBlancs = globulesBlancs;
    }

    // Getter et Setter pour tauxHemoglobine
    public float getTauxHemoglobine() {
        return tauxHemoglobine;
    }

    public void setTauxHemoglobine(float tauxHemoglobine) {
        this.tauxHemoglobine = tauxHemoglobine;
    }

    // Getter et Setter pour tauxPlaquettes
    public float getTauxPlaquettes() {
        return tauxPlaquettes;
    }

    public void setTauxPlaquettes(float tauxPlaquettes) {
        this.tauxPlaquettes = tauxPlaquettes;
    }

    // Getter et Setter pour cholesterol
    public float getCholesterol() {
        return cholesterol;
    }
    public void setTypeSang(TypeSang typeSang) {
        this.typeSang = typeSang;
    }

    public TypeSang getTypeSang() {
        return typeSang;
    }

    public void setCholesterol(float cholesterol) {
        this.cholesterol = cholesterol;
    }
     @Override
    public String toString() {
        return "AnalyseSanguine {" +
                "id=" + getId() +
                
               
                
                ", dateResultat=" + getDateResultat() +               
                ", typeSang=" + typeSang +
                ", globulesRouges=" + globulesRouges +
                ", globulesBlancs=" + globulesBlancs +
                ", tauxHemoglobine=" + tauxHemoglobine +
                ", tauxPlaquettes=" + tauxPlaquettes +
                ", cholesterol=" + cholesterol +
                '}';
    }

   
    
}
    

