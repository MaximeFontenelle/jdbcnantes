/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cours_exercices.exercices.JDBC.DAO;

import cours_exercices.exercices.JDBC.modele.Utilisateur;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fonte
 */
public class DaoUtilisateurs {
    
    private Connection conn;
    
    public DaoUtilisateurs(Connection c){
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
    
    public List<Utilisateur> lectureUtilisateurs(){
        String str = "SELECT * FROM Utilisateurs";
        ResultSet rs;
        List<Utilisateur> list = new ArrayList();
        
        try {
            Statement stmt = this.conn.createStatement();
            rs = stmt.executeQuery(str);
            
            while (rs.next()){
                list.add(new Utilisateur(rs.getInt("id"), rs.getInt("numero_employe"), 
                        rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("login"), 
                        rs.getString("mot_de_passe")));
                
            }
           for(Utilisateur u : list)
                u.prettyPrint();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public void insertUtilisateur(Utilisateur u){
        String s = "INSERT INTO utilisateurs (numero_employe, nom, prenom, email, login, mot_de_passe) values ('"
                + u.getNum_employe() + "', "
                +"'" + u.getNom() + "', "
                +"'" + u.getPrenom() + "', "
                +"'" + u.getEmail() + "', "
                +"'" + u.getLogin() + "', "
                +"'" + u.getMdp()+ "')"; 
        Statement stmt;
        try {
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);
            //System.out.println("Insertion de l'utilisateur : ");
            //u.prettyPrint();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
