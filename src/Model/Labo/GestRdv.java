/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Labo;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author DELL
 */
public class GestRdv {
    private static ObservableList<RendezVous> listTousLesRdv;
    private static int nbRdv=0;

    public GestRdv() {
       this.listTousLesRdv =FXCollections.observableArrayList();
    }

    public ObservableList<RendezVous>  getListTousLesRdv() {
        return listTousLesRdv;
    }

    public void setListTousLesRdv(ObservableList<RendezVous> listTousLesRdv) {
        this.listTousLesRdv = listTousLesRdv;
    }
    
    public void ajouterRdv(RendezVous rv)throws ErreurRdvExistante{
        if (listTousLesRdv.contains(rv))
            throw new ErreurRdvExistante();
        this.listTousLesRdv.add(rv);
        nbRdv++;
    }
    
    public void afficherRdv(){
        this.listTousLesRdv.forEach(System.out::println);
    }
}
