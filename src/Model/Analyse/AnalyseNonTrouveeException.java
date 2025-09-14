/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Analyse;

/**
 *
 * @author ayach
 */
public class AnalyseNonTrouveeException extends Exception  {
      public AnalyseNonTrouveeException(int id) {
        super("Analyse avec l'ID " + id + " non trouvée.");
    }
}
