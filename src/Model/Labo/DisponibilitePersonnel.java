/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Labo;

import java.time.LocalDateTime;

/**
 *
 * @author DELL
 */
public class DisponibilitePersonnel {
    private Personnel personnel;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    public DisponibilitePersonnel(Personnel personnel, LocalDateTime dateDebut, LocalDateTime dateFin) {
        this.personnel = personnel;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "DisponibilitePersonnel{" + "personnel=" + personnel + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }
    
    
}
