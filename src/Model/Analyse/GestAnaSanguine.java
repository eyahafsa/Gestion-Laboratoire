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
public class GestAnaSanguine {
    private static ObservableList<AnalyseSanguine> analysesSanguines;

    public GestAnaSanguine() {
        this.analysesSanguines = FXCollections.observableArrayList();
    }

    public void ajouterAnalyseSanguine( AnalyseSanguine a) {
        this.analysesSanguines.add(a);
    }

    public ObservableList<AnalyseSanguine > getAnaSanguines() {
        return analysesSanguines;
    }

    public void supprimerAnalyseSanguine(AnalyseSanguine analyseSSelectionne) {
         if (analyseSSelectionne != null) {
            analysesSanguines.remove(analyseSSelectionne);
    }
    
}
}