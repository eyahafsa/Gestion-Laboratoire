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
public  final class AnalyseUrine extends Analyse {
    private float pH;
    private float glucose;
    private float proteines;
    private float sangOcculte;
    private float leucocytes;

    public AnalyseUrine( int idprelevement,Date dateResultat, Date dateAnalyse,double p,
                         float pH, float glucose, float proteines, float sangOcculte,float leucocytes) {
        super(idprelevement,dateResultat,dateAnalyse,p );
        
        this.pH = pH;
        this.glucose = glucose;
        this.proteines = proteines;
        this.sangOcculte = sangOcculte;
        this.leucocytes= leucocytes;
        
    }
    // Getter et Setter pour couleur
    
    public void setLeucocytes(float leucocytes) {
        this.leucocytes = leucocytes;
    }

public float getLeucocytes() {
        return leucocytes;
    }

    

    // Getter et Setter pour pH
    public float getPH() {
        return pH;
    }

    public void setPH(float pH) {
        this.pH = pH;
    }

    // Getter et Setter pour glucose
    public float getGlucose() {
        return glucose;
    }

    public void setGlucose(float glucose) {
        this.glucose = glucose;
    }

    // Getter et Setter pour proteines
    public float getProteines() {
        return proteines;
    }

    public void setProteines(float proteines) {
        this.proteines = proteines;
    }

    // Getter et Setter pour sangOcculte
    public float isSangOcculte() {
        return sangOcculte;
    }

    public void setSangOcculte(float sangOcculte) {
        this.sangOcculte = sangOcculte;
    }
     @Override
    public String toString() {
        return "AnalyseUrine {" +
                "id=" + getId() +
               
                ", date Resultat=" + getDateResultat()+
                ", pH=" + pH +
                ", glucose=" + glucose +
                ", proteines=" + proteines +
                ", sangOcculte=" + sangOcculte +
                '}';
    }
}
