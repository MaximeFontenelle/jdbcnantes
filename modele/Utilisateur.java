/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cours_exercices.exercices.JDBC.modele;

/**
 *
 * La table Utilisateurs correpond aux utilisateurs du programme dans une entreprise.
 * Les Utilisateurs ont un id, un numero d'employé unique, un nom, un prenom, un email
 * un login et un mot de passe.
 * @author fonte
 */
public class Utilisateur {
    private int id;
    private int num_employe;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String mdp;
    
    public Utilisateur(int num_employe, String nom, String prenom, String email, String login, String mdp) {
        this.num_employe = num_employe;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mdp = mdp;
    }
    
    public Utilisateur(int id, int num_employe, String nom, String prenom, String email, String login, String mdp) {
        this.id = id;
        this.num_employe = num_employe;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_employe() {
        return num_employe;
    }

    public void setNum_employe(int num_employe) {
        this.num_employe = num_employe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    public void prettyPrint(){
        System.out.println("Utilisateur : " + this.id + " " + this.num_employe + " " + this.nom + " " + this.prenom + " " 
                + this.email + " " + this.login +" " + this.mdp);
    }
}
