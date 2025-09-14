/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Commande;

/**
 *
 * @author Extreme PC
 */
public class CommandeNonAnnulableException extends Exception {
    public CommandeNonAnnulableException(String message){
      super(message);
    }
}
