/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Labo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Model.Analyse.Analyse;
import Model.Analyse.AnalyseSanguine;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class Statistique implements CalculDeRevenus{
    private int idStat;
    private LocalDateTime date;
    private List<Analyse> listAnalyses;
    private Map <String,Double> revenusParAnalyse;

    public Statistique(int idStat, LocalDateTime date) {
        this.idStat = idStat;
        this.date = date;
        revenusParAnalyse=new HashMap();
        listAnalyses=new ArrayList<>();
    }

    public int getIdStat() {
        return idStat;
    }

    public void setIdStat(int idStat) {
        this.idStat = idStat;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Map<String, Double> getRevenusParAnalyse() {
        return revenusParAnalyse;
    }

    public void setRevenusParAnalyse(Map<String, Double> revenusParAnalyse) {
        this.revenusParAnalyse = revenusParAnalyse;
    }
    
    //Besoin de la classe Analyse
    
    /*public void calculerRevenuParAnalyse(){
        
    }*/
    
    public void ajouterAnalyse(Analyse e){
        this.listAnalyses.add(e);
    }
    public void afficherRevenuParAn(){
         this.revenusParAnalyse.entrySet().stream()
            .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

    }

    @Override
    public void calculerRevenuParAnalyse() {
        double sAnSang=0,sAnUr=0; 
        for(Analyse an: listAnalyses){
             System.out.println("Analyse : " + an.getClass().getSimpleName() + ", Prix : " + an.getPrix());
            if(an instanceof AnalyseSanguine)
                sAnSang+=an.getPrix();
            else
                sAnUr+=an.getPrix();  
        }
        this.revenusParAnalyse.put("Analyse sanguine", sAnSang);
        this.revenusParAnalyse.put("Analyse urinaire", sAnUr);
    }
}
