/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafondamentaux.cours_exercices.exercices.JDBC.modele;

/**
 *
 * @author lucas
 */

// La table Fournisseurs correspond aux fournisseurs de l'entreprise.
// Ils ont un id, un numéro unique, un nom, un email et une adresse.
public class Fournisseur {
    private int id;
    private int numero_fournisseur;
    private String nom;
    private String email;
    private String adresse;
    
    public Fournisseur(int numero_fournisseur, String nom, String email, String adresse) {
        this.numero_fournisseur = numero_fournisseur;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
    }
    
    public Fournisseur(int id, int numero_fournisseur, String nom, String email, String adresse) {
        this.id = id;
        this.numero_fournisseur = numero_fournisseur;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_fournisseur() {
        return this.numero_fournisseur;
    }

    public void setNumero_fournisseur(int numero_fournisseur) {
        this.numero_fournisseur = numero_fournisseur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public void prettyPrint(){
        System.out.println("Fournisseur : " 
        + this.id + " " 
        + this.numero_fournisseur + " " 
        + this.nom + " " 
        + this.email + " " 
        + this.adresse);
    }
}