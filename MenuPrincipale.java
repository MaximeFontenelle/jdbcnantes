/**
 * Exercice JDBC :
 * 
 * Ecrire un programme divisié en plusieurs fichiers et dossiers.
 * 
 * Un dossier dao pour la partie de code accedant à la BDD.
 * Un dossier modele pour les objets utilisés sous forme de JavaBean.
 * Un dossier main pour le programme principal gérant les menus.
 * Vous pouvez creer d'autres dossiers si vous le juger necessaire.
 * 
 * Créer des fichiers differents selon les besoin,
 * et importer les dans les autres fichiers si nécessaire.
 * 
 * Description : 
 * 
 * Creér la base de données MySQL si elle n'existe pas. Nommée la comme vous le souhaité.
 * Connectez vous à la BDD et créer les tables de la BDD si elles n'existent pas.
 * Ces tables sont : Utilisateurs, Clients, Fournisseurs et Articles.
 * 
 * La table Utilisateurs correpond aux utilisateurs du programme dans une entreprise.
 * Les Utilisateurs ont un id, un numero d'employé unique, un nom, un prenom, un email
 * un login et un mot de passe.
 * 
 * La table Clients cotiendra les client de l'entreprise. Ils ont un id, un numéro unique,
 * un nom, un prénom, un email et une adresse.
 * 
 * La table Fournisseurs correspond aux fournisseurs de l'entreprise.
 * Ils ont un id, un numéro unique, un nom, un email et une adresse.
 * 
 * La table Article correspond aux articles acheté au fournisseurs et vendu aux clients.
 * Ils ont un id, un numero unique, un champs indiquant si c'est un article acheter ou vendu, un nom, une description.
 * 
 * les opérations à faire sur les toutes tables de la BDD et à decrire dans les menus sont :
 * la lectures complète.
 * la lecture d'un enregistrement selon l'id.
 * l'ecriture.
 * la modification.
 * la suppression.
 * 
 * Pour les menus, faites un premier menu pour choisir la table sur laquelle on veux faire une opération.
 * Puis un sous-menu corresondant aux différentes opérations.
 * 
 * Faites les controles necesaires sur les opérations pour eviter les incohérences et les erreur SQL.
 * 
 * Tous les champs de toutes les tables sont obligatoires.
 * 
 * Faire les javadoc pour toutes les méthodes et classes.
 */

package cours_exercices.exercices.JDBC;

import cours_exercices.exercices.JDBC.DAO.CreationJdbcNantes;
import cours_exercices.exercices.JDBC.DAO.DaoArticle;
import cours_exercices.exercices.JDBC.DAO.DaoUtilisateurs;
import cours_exercices.exercices.JDBC.modele.Article;
import cours_exercices.exercices.JDBC.modele.Utilisateur;
import java.util.List;

/**
 * @author Twixy
 */
public class MenuPrincipale {
    public static void main(String[] args) {
        CreationJdbcNantes jdbc = new CreationJdbcNantes();
        jdbc.createDatabase();
        jdbc.createTables();
        
        DaoUtilisateurs u = new DaoUtilisateurs(jdbc.getConn());
        
        Utilisateur john = new Utilisateur(1, "John", "Doe", "john@doe.com", "john", "john");
        Utilisateur jane = new Utilisateur(2, "Jane", "Doe", "janedoe@doe.com", "jad", "jane");
        u.insertUtilisateur(jane);
        
        // lecture en base
        jane = u.lectureUtilisateur(2);
        jane.setEmail("coucoucoucou");
        u.modificationUtilisateur(jane);
        
        
        DaoArticle da = new DaoArticle(jdbc.getConn());
        Article a = new Article (41, true, "machine a cafe", "super machine pour faire du cafe");
        Article b = new Article (1, true, "machine laver", "super machine pour laver");
        
        da.insertionArticle(a);
        da.insertionArticle(b);
        
        List<Article> listArticles = da.lectureArticles();
        
        for(Article art : listArticles){
            art.setNom(art.getNom() + "modifie");
            da.modificationArticle(art);            
        }
        
        Article test = da.lectureArticle(12);
        test.prettyPrint();
//            da.suppressionArticle(art);
    }
}
