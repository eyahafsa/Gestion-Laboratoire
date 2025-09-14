/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Labo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author DELL
 */
public class RendezVous {
    private int idRdv;
    private int idPatient;
    LocalDate dateR;
    private LocalTime heure;
    String typesAnalyses;
    
    public RendezVous(int idRdv,int idPatient, LocalDate dateR, LocalTime heure,String tyAn) {
        this.idPatient = idPatient;
        this.dateR = dateR;
        this.heure = heure;
        this.typesAnalyses=tyAn;
        this.idRdv=idRdv;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public LocalDate getDateR() {
        return dateR;
    }

    public void setDateR(LocalDate dateR) {
        this.dateR = dateR;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public String getTypesAnalyses() {
        return typesAnalyses;
    }

    public void setTypesAnalyses(String typesAnalyses) {
        this.typesAnalyses = typesAnalyses;
    }

    public int getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(int idRdv) {
        this.idRdv = idRdv;
    }

    @Override
    public String toString() {
        return "RendezVous{" + "idPatient=" + idPatient + ", dateR=" + dateR + ", heure=" + heure + ", typesAnalyses=" + typesAnalyses + '}';
    }
    
    
    
    
    
    
    
}
