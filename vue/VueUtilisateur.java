/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafondamentaux.cours_exercices.exercices.JDBC.vue;

import java.util.List;
import java.util.Scanner;
import javafondamentaux.cours_exercices.exercices.JDBC.DAO.CreationJdbcNantes;
import javafondamentaux.cours_exercices.exercices.JDBC.DAO.DaoUtilisateurs;
import javafondamentaux.cours_exercices.exercices.JDBC.modele.Utilisateur;

/**
 *
 * @author lucas
 */
public class VueUtilisateur {
    public VueUtilisateur(){
        
        System.out.println("Interface de gestion des utilisateurs");
        System.out.println("Opération à réaliser : "
                + "\n1 - Créer"
                + "\n2 - Afficher tout"
                + "\n3 - Afficher (id)"
                + "\n4 - Modifier (id)"
                + "\n5 - Supprimer (id)");
        Scanner scan = new Scanner(System.in);
        String inputUser = "";
        while (!inputUser.equals("exit")) {
            inputUser = scan.nextLine();
            switch (inputUser) {
                case "1" -> insererUtilisateur();
                case "2" -> listeUtilisateur();     
                case "3" -> lireUtilisateur();
                case "4" -> modifierUtilisateur();
                case "5" -> supprimerUtilisateur();
                default -> System.out.println("rien du tout");
            }
        }
    }
    public void insererUtilisateur(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creation d'un nouvel utilisateur : ");
        System.out.println("Entrez le numéro d'employé : ");
        int numEmploye = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Entrez le nom : ");
        String nom = scanner.nextLine();
        System.out.println("Entrez le prénom : ");
        String prenom = scanner.nextLine();
        System.out.println("Entrez le email : ");
        String email = scanner.nextLine();
        System.out.println("Entrez le login : ");
        String login = scanner.nextLine();
        System.out.println("Entrez le mot de passe : ");
        String mdp = scanner.nextLine();

        Utilisateur utilisateur = new Utilisateur(numEmploye, nom, prenom, email, login, mdp);        
        CreationJdbcNantes jdbc = new CreationJdbcNantes();
        jdbc.execute("use JdbcNantes");
        DaoUtilisateurs daoUtilisateurs = new DaoUtilisateurs(jdbc.getConn());

        daoUtilisateurs.insertUtilisateur(utilisateur);
        System.out.println("Utilisateur crée !");
    }    
    public void listeUtilisateur(){
        CreationJdbcNantes jdbc = new CreationJdbcNantes();
        jdbc.execute("use JdbcNantes");
        DaoUtilisateurs daoUtilisateurs = new DaoUtilisateurs(jdbc.getConn());
        List<Utilisateur> utilisateurs = daoUtilisateurs.lectureUtilisateurs();
        for (Utilisateur utilisateur : utilisateurs)
            utilisateur.prettyPrint();
    }
    
    public void lireUtilisateur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez l'id de l'utilisateur : ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        CreationJdbcNantes jdbc = new CreationJdbcNantes();
        jdbc.execute("use JdbcNantes");
        DaoUtilisateurs daoUtilisateurs = new DaoUtilisateurs(jdbc.getConn());
        Utilisateur utilisateur = daoUtilisateurs.lectureUtilisateur(userId);

        if (utilisateur != null) {
            utilisateur.prettyPrint();
        } else {
            System.out.println("Utilisateur non trouvé.");
        }
    }

    public void modifierUtilisateur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez l'id de l'utilisateur à modifier : ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        CreationJdbcNantes jdbc = new CreationJdbcNantes();
        jdbc.execute("use JdbcNantes");
        DaoUtilisateurs daoUtilisateurs = new DaoUtilisateurs(jdbc.getConn());
        Utilisateur utilisateur = daoUtilisateurs.lectureUtilisateur(userId);
        
        if (utilisateur != null) {
            utilisateur.prettyPrint();
            System.out.println("Modification de l'utilisateur : " + utilisateur.getNom() + " " + utilisateur.getPrenom());
            System.out.println("Entrez le nouveau numéro d'employé : ");
            int numEmploye = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
            System.out.println("Entrez le nouveau nom : ");
            String nom = scanner.nextLine();
            System.out.println("Entrez le nouveau prénom : ");
            String prenom = scanner.nextLine();
            System.out.println("Entrez le nouvel email : ");
            String email = scanner.nextLine();
            System.out.println("Entrez le nouveau login : ");
            String login = scanner.nextLine();
            System.out.println("Entrez le nouveau mot de passe : ");
            String mdp = scanner.nextLine();

            utilisateur.setNum_employe(numEmploye);
            utilisateur.setNom(nom);
            utilisateur.setPrenom(prenom);
            utilisateur.setEmail(email);
            utilisateur.setLogin(login);
            utilisateur.setMdp(mdp);

            daoUtilisateurs.modificationUtilisateur(utilisateur);
            System.out.println("Utilisateur modifié.");
        } else {
            System.out.println("Utilisateur non trouvé.");
        }
    }
    public void supprimerUtilisateur(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez l'id de l'utilisateur à supprimer : ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        CreationJdbcNantes jdbc = new CreationJdbcNantes();
        jdbc.execute("use JdbcNantes");
        DaoUtilisateurs daoUtilisateurs = new DaoUtilisateurs(jdbc.getConn());
        daoUtilisateurs.suppressionUtilisateur(userId);
        System.out.println("Utilisateur à été supprimé !");
    }
}
