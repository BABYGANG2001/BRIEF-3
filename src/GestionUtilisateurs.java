import java.util.ArrayList;
import java.util.Scanner;

public class GestionUtilisateurs {
    private static ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
    private static ArrayList<Rôle> rôles = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initialiserRôles();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un utilisateur");
            System.out.println("2. Rechercher un utilisateur");
            System.out.println("3. Modifier un utilisateur");
            System.out.println("4. Supprimer un utilisateur");
            System.out.println("5. Afficher tous les utilisateurs");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1 -> ajouterUtilisateur(scanner);
                case 2 -> rechercherUtilisateur(scanner);
                case 3 -> modifierUtilisateur(scanner);
                case 4 -> supprimerUtilisateur(scanner);
                case 5 -> afficherUtilisateurs();
                case 6 -> {
                    System.out.println("Au revoir !");
                    return;
                }
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    private static void initialiserRôles() {
        rôles.add(new Rôle(1, "Administrateur"));
        rôles.add(new Rôle(2, "Employé"));
        rôles.add(new Rôle(3, "Client"));
    }

    private static void ajouterUtilisateur(Scanner scanner) {
        System.out.print("Nom : ");
        String nom = scanner.next();
        System.out.print("Âge : ");
        int age = scanner.nextInt();
        System.out.print("Email : ");
        String email = scanner.next();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.next();
        System.out.println("Rôles disponibles :");
        for (Rôle rôle : rôles) {
            System.out.println(rôle.getId() + ". " + rôle.getNom());
        }
        System.out.print("Choisissez un rôle : ");
        int idRôle = scanner.nextInt();
        Rôle rôle = rôles.stream().filter(r -> r.getId() == idRôle).findFirst().orElse(null);

        if (rôle == null) {
            System.out.println("Rôle invalide !");
            return;
        }

        Utilisateur utilisateur = new Utilisateur(nextId++, nom, age, email, motDePasse, rôle);
        utilisateurs.add(utilisateur);
        System.out.println("Utilisateur ajouté avec succès !");
    }

    private static void rechercherUtilisateur(Scanner scanner) {
        System.out.print("Entrez l'ID de l'utilisateur : ");
        int id = scanner.nextInt();
        Utilisateur utilisateur = utilisateurs.stream().filter(u -> u.getId() == id).findFirst().orElse(null);

        if (utilisateur == null) {
            System.out.println("Utilisateur non trouvé.");
        } else {
            afficherDetailsUtilisateur(utilisateur);
        }
    }

    private static void modifierUtilisateur(Scanner scanner) {
        System.out.print("Entrez l'ID de l'utilisateur à modifier : ");
        int id = scanner.nextInt();
        Utilisateur utilisateur = utilisateurs.stream().filter(u -> u.getId() == id).findFirst().orElse(null);

        if (utilisateur == null) {
            System.out.println("Utilisateur non trouvé.");
            return;
        }

        System.out.print("Nouveau nom (laissez vide pour ne pas changer) : ");
        String nom = scanner.next();
        if (!nom.isBlank()) utilisateur.setNom(nom);

        System.out.print("Nouvel âge (ou 0 pour ne pas changer) : ");
        int age = scanner.nextInt();
        if (age > 0) utilisateur.setAge(age);

        System.out.print("Nouvel email (laissez vide pour ne pas changer) : ");
        String email = scanner.next();
        if (!email.isBlank()) utilisateur.setEmail(email);

        System.out.println("Utilisateur mis à jour avec succès !");
    }

    private static void supprimerUtilisateur(Scanner scanner) {
        System.out.print("Entrez l'ID de l'utilisateur à supprimer : ");
        int id = scanner.nextInt();
        boolean supprimé = utilisateurs.removeIf(u -> u.getId() == id);

        if (supprimé) {
            System.out.println("Utilisateur supprimé avec succès !");
        } else {
            System.out.println("Utilisateur non trouvé.");
        }
    }

    private static void afficherUtilisateurs() {
        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur enregistré.");
            return;
        }

        for (Utilisateur utilisateur : utilisateurs) {
            afficherDetailsUtilisateur(utilisateur);
        }
    }

    private static void afficherDetailsUtilisateur(Utilisateur utilisateur) {
        System.out.println("ID : " + utilisateur.getId());
        System.out.println("Nom : " + utilisateur.getNom());
        System.out.println("Âge : " + utilisateur.getAge());
        System.out.println("Email : " + utilisateur.getEmail());
        System.out.println("Rôle : " + utilisateur.getRôle().getNom());
        System.out.println("-----------------------------");
    }
}
