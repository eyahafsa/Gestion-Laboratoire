/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Analyse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ayach
 */
public class GestAnaUrine {
    private ObservableList<AnalyseUrine> analysesUrines;

    public GestAnaUrine() {
        this.analysesUrines = FXCollections.observableArrayList();
    }

    /**
     * Ajoute une analyse urinaire à la liste.
     * @param a L'analyse urinaire à ajouter.
     */
    public void ajouterAnalyseUrinaire(AnalyseUrine a) {
        this.analysesUrines.add(a);
    }

   
    public ObservableList<AnalyseUrine> getAnaUrines() {
        return analysesUrines;
    }

    
    public void supprimerAnalyseUrinaire(AnalyseUrine analyseUSelectionne) {
        if (analyseUSelectionne != null) {
            analysesUrines.remove(analyseUSelectionne);
        }
    }
}


