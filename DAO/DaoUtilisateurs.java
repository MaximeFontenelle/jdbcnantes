package javafondamentaux.cours_exercices.exercices.JDBC.DAO;

import javafondamentaux.cours_exercices.exercices.JDBC.modele.Utilisateur;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fonte
 */
public class DaoUtilisateurs {
    
    private Connection conn;
    
    public DaoUtilisateurs(Connection c){
        this.conn = c;
    }
    
    public Utilisateur lectureUtilisateur(int userId){
            String str = "SELECT * FROM Utilisateurs WHERE id='" + userId + "'";
            ResultSet rs;

            try {
                Statement stmt = this.conn.createStatement();
                rs = stmt.executeQuery(str);

                if (rs.next())
                    return new Utilisateur(rs.getInt("id"), rs.getInt("numero_employe"), rs.getString("nom"), 
                        rs.getString("prenom"),  rs.getString("email"),  rs.getString("login"),  
                        rs.getString("mot_de_passe"));

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return null;
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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    public void modificationUtilisateur(Utilisateur a) {
        String s = "UPDATE Utilisateurs SET "
                + "numero_employe = " + a.getNum_employe()
                + ", nom = '" + a.getNom() + "'"
                + ", prenom = '" + a.getPrenom() + "'"
                + ", email = '" + a.getEmail()+ "'"
                + ", login = '" + a.getLogin()+ "'"
                + ", mot_de_passe = '" + a.getMdp() + "'"
                + " WHERE id = " +a.getId();
        Statement stmt;
        try {
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
    }
    
    public void suppressionUtilisateur(int userId) {
        String s = "DELETE FROM Utilisateurs WHERE id = " + userId;
        Statement stmt;
        try {
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
    }
    
}
