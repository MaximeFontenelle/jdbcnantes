/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafondamentaux.cours_exercices.exercices.JDBC.DAO;


import java.sql.*;

/**
 *
 * @author fonte
 */
public class CreationJdbcNantes {
   
    private Connection conn;

    public Connection getConn() {
        return this.conn;
    }
    
    public CreationJdbcNantes() {      
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", "root", "root");           
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void execute(String s){
        Statement stmt;
        
        try {
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void createDatabase(){
            String str1 = "CREATE DATABASE IF NOT EXISTS JdbcNantes CHARACTER SET utf8;";
            String str2 = "use JdbcNantes";
            System.out.println("Cr?ation de la base de donn?es");
            this.execute(str1);
            this.execute(str2);
    }
    
    public void createTables(){
        String str1 = "CREATE TABLE IF NOT EXISTS Utilisateurs ("
                + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "numero_employe int NOT NULL, "
                + "constraint uc_employe unique (numero_employe), "
                + "nom Varchar (50) NOT NULL, "
                + "prenom Varchar (50) NOT NULL, "
                + "email Varchar (50) NOT NULL, "
                + "login Varchar (10), "
                + "mot_de_passe Varchar (20) NOT NULL)";
        
        String str2 = "CREATE TABLE IF NOT EXISTS Clients ("
                    + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    + "numero int NOT NULL, "
                    + "constraint uc_clients unique (numero), "
                    + "nom Varchar (50) NOT NULL, "
                    + "prenom Varchar (50) NOT NULL, "
                    + "email Varchar (50) NOT NULL, "
                    + "adresse Varchar (255) NOT NULL )";
                    
        //La table Fournisseurs correspond aux fournisseurs de l'entreprise.
        //Ils ont un id, un num?ro unique, un nom, un email et une adresse.
        String str3 = "CREATE TABLE IF NOT EXISTS Fournisseurs ("
                    + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    + "numero_fournisseur int NOT NULL, "
                    + "constraint uc_fournisseur unique (numero_fournisseur), "
                    + "nom Varchar (50) NOT NULL, "
                    + "email Varchar (50) NOT NULL, "
                    + "adresse Varchar (255) NOT NULL )";
        
        //La table Article correspond aux articles achet? au fournisseurs et vendu aux clients.
        //Ils ont un id, un numero unique, un champs indiquant si c'est un article acheter ou vendu, un nom, une description.
        String str4 = "CREATE TABLE IF NOT EXISTS Articles ("
                    + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    + "numero_article int(10) NOT NULL, "
                    + "constraint uc_article unique (numero_article), "
                    + "nom Varchar (50) NOT NULL, "
                    + "etat Boolean default NULL,"
                    + "description Varchar (255) NOT NULL )";
        
        System.out.println("Creation de la table utilisateurs");
        this.execute(str1);
        
        System.out.println("Creation de la table clients");
        this.execute(str2);
        System.out.println("Creation de la table fournisseurs");
        this.execute(str3);
        System.out.println("Creation de la table articles");
        this.execute(str4);

    }    
}