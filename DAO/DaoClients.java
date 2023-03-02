/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cours_exercices.exercices.JDBC.dao;

import cours_exercices.exercices.JDBC.modele.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Administrateur
 */
public class DaoClients {    
    private Connection conn;
    public DaoClients(Connection c) {
        this.conn = c;
    }
    
    public void excute(String s) {
        Statement stmt;        
        try {
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);
        } catch (SQLException ex) {
            System.out.println("ex.getMessage()");
        }
    }        
   
    public List<Client> lectureClients(){
        String str = "SELECT * FROM Clients";
        ResultSet rs;
        List<Client> list = new ArrayList();    
            
        try {
            Statement stmt = this.conn.createStatement();
            rs = stmt.executeQuery(str);
            
            while (rs.next()) {
                list.add(new Client(rs.getInt("id"), rs.getInt("numero"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("adresse")));
            }
            for(Client client : list)
                client.prettyPrint();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public void lectureClient(Client client){
        String str = "SELECT * FROM Clients WHERE" + client.getId();
                
        ResultSet rs;
            
        try {
            Statement stmt = this.conn.createStatement();
            rs = stmt.executeQuery(str);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void insertClient(Client client){
        String s = "INSERT INTO Clients (numero, nom, prenom, email, adresse) VALUES ('"        
        + client.getNumero() + "',"
        +"'" + client.getNom() + "',"
        +"'" + client.getPrenom() + "',"
        +"'" + client.getEmail() + "', "
        +"'" + client.getAdresse() + "')";
        
        Statement stmt;
        try {
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updateClient(Client client){
        String s = "UPDATE Clients SET "
                + "numero = " + client.getNumero() + ", " 
                + "nom = '" + client.getNom() + "', " 
                + "prenom = '" + client.getPrenom() + "', " 
                + "email = '" + client.getEmail() + "', " 
                + "adresse = '" + client.getAdresse() + "' " 
                + "WHERE id = " + client.getId();
        System.out.println(s);        
        Statement stmt;
        try {
            System.out.println("modification du client : " + client.getNom());
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);
            System.out.println("Le client " + client.getNom() + " a ete modifie ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }               
    }
    
    
    public void deleteClient(Client client){
        String s = "DELETE FROM Clients WHERE" + client.getId();
        
        Statement stmt;
        try {
            System.out.println("Supression du client : " + client.getNom());
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);
            System.out.println("Le client " + client.getNom() + " a ete suprime ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
}
