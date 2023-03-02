/**
 * Exercice JDBC :
 * 
 * Ecrire un programme divisié en plusieurs fichiers et dossiers.
 * 
 * Un dossier dao pour la partie de code accedant ? la BDD.
 * Un dossier modele pour les objets utilis?s sous forme de JavaBean.
 * Un dossier main pour le programme principal g?rant les menus.
 * Vous pouvez creer d'autres dossiers si vous le juger necessaire.
 * 
 * Cr?er des fichiers differents selon les besoin,
 * et importer les dans les autres fichiers si n?cessaire.
 * 
 * Description : 
 * 
 * Creer la base de donn?es MySQL si elle n'existe pas. Nommée la comme vous le souhaiter.
 * Connectez vous ? la BDD et cr?er les tables de la BDD si elles n'existent pas.
 * Ces tables sont : Utilisateurs, Clients, Fournisseurs et Articles.
 * 
 * La table Utilisateurs correpond aux utilisateurs du programme dans une entreprise.
 * Les Utilisateurs ont un id, un numero d'employ? unique, un nom, un prenom, un email
 * un login et un mot de passe.
 * 
 * La table Clients cotiendra les client de l'entreprise. Ils ont un id, un num?ro unique,
 * un nom, un pr?nom, un email et une adresse.
 * 
 * La table Fournisseurs correspond aux fournisseurs de l'entreprise.
 * Ils ont un id, un num?ro unique, un nom, un email et une adresse.
 * 
 * La table Article correspond aux articles achet? au fournisseurs et vendu aux clients.
 * Ils ont un id, un numero unique, un champs indiquant si c'est un article acheter ou vendu, un nom, une description.
 * 
 * les op?rations ? faire sur les toutes tables de la BDD et ? decrire dans les menus sont :
 * la lectures compl?te.
 * la lecture d'un enregistrement selon l'id.
 * l'ecriture.
 * la modification.
 * la suppression.
 * 
 * Pour les menus, faites un premier menu pour choisir la table sur laquelle on veux faire une op?ration.
 * Puis un sous-menu corresondant aux diff?rentes op?rations.
 * 
 * Faites les controles necesaires sur les op?rations pour eviter les incoh?rences et les erreur SQL.
 * 
 * Tous les champs de toutes les tables sont obligatoires.
 * 
 * Faire les javadoc pour toutes les m?thodes et classes.
 */

package cours_exercices.exercices.JDBC;

import cours_exercices.exercices.JDBC.DAO.CreationJdbcNantes;
import cours_exercices.exercices.JDBC.dao.DaoClients;
import cours_exercices.exercices.JDBC.modele.Client;

/**
 * @author Twixy
 */
public class MenuPrincipale {
    public static void main(String[] args) {
        CreationJdbcNantes jdbc = new CreationJdbcNantes();
        jdbc.createDatabase();
        jdbc.createTables();
        
        DaoClients client = new DaoClients(jdbc.getConn());
        client.lectureClients();
        
        Client khadidja = new Client(1, 1, "khadidja", "SIDELARBI", "kha_didja85@doe.com", "Orléans");
        
        client.lectureClients();
        client.lectureClient(khadidja);        
        client.insertClient(khadidja);
        client.updateClient(khadidja);
        client.deleteClient(khadidja);
        
    }
}