/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafondamentaux.cours_exercices.exercices.JDBC.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafondamentaux.cours_exercices.exercices.JDBC.modele.Fournisseur;
/**
 *
 * @author lucas
 */
public class DaoFournisseurs {
    
    private Connection conn;
    
    public DaoFournisseurs(Connection c){
        this.conn = c;
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
    
    public List<Fournisseur> lectureFournisseurs(){
        String s = "SELECT * FROM fournisseurs";
        ResultSet rs;
        List<Fournisseur> list = new ArrayList();
        
        try {
            Statement stmt = this.conn.createStatement();
            rs = stmt.executeQuery(s);
            
            while (rs.next()){
                list.add(new Fournisseur(
                        rs.getInt("id"), 
                        rs.getInt("numero_fournisseur"), 
                        rs.getString("nom"), 
                        rs.getString("email"), 
                        rs.getString("adresse"))); 
            }
           for(Fournisseur u : list)
                u.prettyPrint();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public Fournisseur lectureFournisseur(Fournisseur u){
        String s = "SELECT * FROM Fournisseurs WHERE id = " + u.getId();
        ResultSet rs;
        try {
            Statement stmt = this.conn.createStatement();
            rs = stmt.executeQuery(s);
            System.out.println("lecture de l'utilisateur : ");
            if (rs.next()){
                Fournisseur fournisseur = new Fournisseur(
                        rs.getInt("id"), 
                        rs.getInt("numero_fournisseur"), 
                        rs.getString("nom"), 
                    rs.getString("email"), 
                        rs.getString("adresse"));
                u.prettyPrint();
                return fournisseur;   
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public void insererFournisseur(Fournisseur u){
        String s = "INSERT INTO Fournisseurs (numero_fournisseur, nom, email, adresse) values ('"
                + u.getNumero_fournisseur() + "', "
                +"'" + u.getNom() + "', "
                +"'" + u.getEmail() + "', "
                +"'" + u.getAdresse() + "')"; 
        
        Statement stmt;
        try {
            System.out.println("Insertion de l'utilisateur : ");
            u.prettyPrint();
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
    public void modifierFournisseur(Fournisseur u){
        String s = "UPDATE Fournisseurs SET "
                + "numero_fournisseur = '" + u.getNumero_fournisseur() + "', "
                + "nom = '" + u.getNom() + "', "
                + "email = '" + u.getEmail() + "', "
                + "adresse = '" + u.getAdresse() + "' "
                + "WHERE id = " + u.getId();
        Statement stmt;
        try {
            System.out.println("Modification du fournisseur : ");
            u.prettyPrint();
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimmerFournisseur(Fournisseur u){
        String s = "DELETE FROM fournisseurs WHERE" + u.getId();
        Statement stmt;
        try {
            System.out.println("Suppression de l'utilisateur : ");
            u.prettyPrint();
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

