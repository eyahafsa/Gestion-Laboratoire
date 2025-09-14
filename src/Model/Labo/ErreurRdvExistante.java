/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Labo;

/**
 *
 * @author DELL
 */
public class ErreurRdvExistante extends Exception {

    public ErreurRdvExistante() {
        super("Attention!!!Le rendez-vous existe déjà");
    }
    
}
