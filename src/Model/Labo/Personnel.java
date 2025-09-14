/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Labo;

/**
 *
 * @author DELL
 */
public final class Personnel extends Personne{
    private String posteOcc; 
    private boolean isChef;

    public Personnel(String posteOcc, boolean isChef, String nom, String prénom, String mail, long tel,String acces) {
        super(nom, prénom, mail, tel,acces);
        this.posteOcc = posteOcc;
        this.isChef = isChef;
    }

    public Personnel(String posteOcc, String nom, String prénom, String mail, long tel,String acces) {
        super(nom, prénom, mail, tel, acces);
        this.posteOcc = posteOcc;
    }

    public String getPosteOcc() {
        return posteOcc;
    }

    public void setPosteOcc(String posteOcc) {
        this.posteOcc = posteOcc;
    }

    public boolean isIsChef() {
        return isChef;
    }

    public void setIsChef(boolean isChef) {
        this.isChef = isChef;
    }
    @Override
    public void afficher(){
        super.afficher();
        System.out.print("Poste occupe: "+this.posteOcc);
        if(isChef)
            System.out.println("Laborantin Chef");
    }

    @Override
    public String toString() {
        return "Personnel{" + super.toString()+ "posteOcc=" + posteOcc + ", isChef=" + isChef + '}';
    }
    
    
}
