/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Labo;


public sealed class Personne permits Personnel, Patient, Stagiaire{
    private String nom;
    private String prénom;
    private String mail;
    private long tel;
    private  String acces ;

    public Personne(String nom, String prénom, String mail, long tel,String acces) {
        this.nom = nom;
        this.prénom = prénom;
        this.mail = mail;
        this.tel = tel;
        this.acces=acces;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getAcces() {
        return acces;
    }

    public void setAcces(String acces) {
        this.acces = acces;
    }

    @Override
    public String toString() {
        return  "nom=" + nom + ", pr\u00e9nom=" + prénom + ", mail=" + mail + ", tel=" + tel + ", acces=" + acces + '}';
    }
    
    public void afficher(){
        StringBuffer aff=new StringBuffer();
            aff.append("Prenom: "+this.prénom+", Nom: "+this.nom+ ", Mail: "+this.mail+", Telephone: "+this.tel) ;   
        if(!this.acces.equals(null))
            aff.append(", Acces: "+this.acces);
    }
}
