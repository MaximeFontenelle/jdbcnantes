/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cours_exercices.exercices.JDBC.modele;

/**
 *
 * La table Article correspond aux articles acheté au fournisseurs et vendu aux clients.
 * Ils ont un id, un numero unique, un champs indiquant si c'est un article acheter ou vendu, un nom, une description.
 * 
 * @author fonte
 */
public class Article {
    private int id;
    private int numero;
    private Boolean etat;
    private String nom;
    private String description;
    
    public Article (int numero, Boolean etat, String nom, String description) {
        this.numero = numero;
        this.etat = etat;
        this.nom = nom;
        this.description = description;
    }
    
    public Article(int id, int numero, Boolean etat, String nom, String description) {
        this.id = id;
        this.numero = numero;
        this.etat = etat;
        this.nom = nom;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }    
    
    public void prettyPrint(){
        System.out.println("Article : " + this.id + " " + this.numero + " " + (this.etat ? "acheté " : "vendu ") 
                + this.nom + " " + this.description);
    }
}
