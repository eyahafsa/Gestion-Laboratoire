/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Analyse;
import Model.Labo.Patient;

/**
 *
 * @author ayach
 */
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.stream.Collectors;

public sealed  class  Analyse  permits AnalyseSanguine,AnalyseUrine{
    int idprelevement;
    Date  dateResultat ;   
    Date dateAnalyse ;
    double prix;
    
    public Analyse( int idprelevement, Date dateResultat ,Date dateAnalyse, double p )
    {
    this.idprelevement=idprelevement ;
    this.dateResultat=dateResultat;
    this.dateAnalyse=dateAnalyse;
    this.prix=p;
    }
    public void setIdprelevement(int idprelevement) {
        this.idprelevement = idprelevement;
    }

    public int getIdprelevement() {
        return idprelevement;
    } 
    
 public int getId() {
        return idprelevement;
    }

    public void setId(int id) {
        this.idprelevement = id;
    }
    public  Date getDateAnalyse()
    {return dateAnalyse;}

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public void setDateResultat(Date dateResultat) {
        this.dateResultat = dateResultat;
    }

    public Date getDateResultat() {
        return dateResultat;
    }
  

    // Getter et Setter pour nom
   

    // Getter et Setter pour prix
   
    // Getter et Setter pour delaiResultat
    
    
    
     // Méthode pour calculer la date de résultat en fonction du délai
    
    
     // une méthode filtrage d'analyses par prix utilisant les streams
    
    
   /* public static List<Analyse> filtrerAnalysesParPrix(List<Analyse> analyses, float prixMin) {
        return analyses.stream()
                .filter(a -> a.getPrix() >= prixMin)
                .collect(Collectors.toList());*/
    
    
    @Override
    public String toString() {
        return "Analyse{" + "idprelevement=" + idprelevement + ", dateResultat=" + dateResultat + ", dateAnalyse=" + dateAnalyse + '}';
    }

    
    
    
    
    }



    
  
    

