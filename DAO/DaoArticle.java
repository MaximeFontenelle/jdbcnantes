/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafondamentaux.cours_exercices.exercices.JDBC.DAO;

import javafondamentaux.cours_exercices.exercices.JDBC.modele.Article;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fonte
 */
public class DaoArticle {
      
    private Connection conn;
    
    public DaoArticle(Connection c){
        this.conn = c;
    }
    
    public Article lectureArticle(int a){
        String str = "SELECT * FROM Articles WHERE id='" + a + "'";
        ResultSet rs;
        
        try {
            Statement stmt = this.conn.createStatement();
            rs = stmt.executeQuery(str);
            
            if (rs.next())
                return new Article(rs.getInt("id"), rs.getInt("numero_article"), rs.getBoolean("etat"), 
                        rs.getString("nom"), rs.getString("description"));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public List<Article> lectureArticles(){
        String str = "SELECT * FROM Articles";
        ResultSet rs;
        List<Article> list = new ArrayList();
        
        try {
            Statement stmt = this.conn.createStatement();
            rs = stmt.executeQuery(str);
            
            while (rs.next()){
                list.add(new Article(rs.getInt("id"), rs.getInt("numero_article"), rs.getBoolean("etat"), 
                        rs.getString("nom"), rs.getString("description")));
                
            }
           for(Article a : list)
                a.prettyPrint();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public void insertionArticle(Article u){
        String s = "INSERT INTO Articles (numero_article, etat, nom, description) values ('"
                + u.getNumero() + "', "
                +"'" + (u.getEtat() ? 1 : 0) + "', "
                +"'" + u.getNom() + "', "
                +"'" + u.getDescription() + "')"; 
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
    
    public void modificationArticle(Article a) {
        String s = "UPDATE Articles SET "
                + "numero_article = " + a.getNumero()
                + ", nom = '" + a.getNom() + "'"
                + ", etat = " + (a.getEtat() ? 1 : 0)
                + ", description = '" + a.getDescription() + "'"
                + " WHERE id = " +a.getId();
        Statement stmt;
        try {
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
    }
    
    public void suppressionArticle(Article a) {
        String s = "DELETE FROM Articles WHERE id = " +a.getId();
        Statement stmt;
        try {
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
    }
}