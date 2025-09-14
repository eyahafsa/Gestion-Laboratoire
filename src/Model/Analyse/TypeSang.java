/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Analyse;

/**
 *
 * @author ayach
 */
public enum TypeSang { A_POSITIF("A+"),
    A_NEGATIF("A-"),
    B_POSITIF("B+"),
    B_NEGATIF("B-"),
    AB_POSITIF("AB+"),
    AB_NEGATIF("AB-"),
    O_POSITIF("O+"),
    O_NEGATIF("O-"); 
private final String label;
 TypeSang(String label) {
        this.label = label;
    }
public String getLabel() {
        return label;
    }
 @Override
    public String toString() {
        return label;
    }
}
