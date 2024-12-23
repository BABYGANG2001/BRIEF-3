import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuprogramme = true;
        while (continuprogramme) {
            System.out.println(" le menu de gestions de comptes:");
            System.out.println("1:ajouter les  utilisateur");
            System.out.println("2:afficher les utilisateurs");
            System.out.println("3:modifier les utilisateurs");
            System.out.println("4:rechercher les utilisateurs");
            System.out.println("5:supprimer les utilisateurs");
            System.out.println("6:Quitter");
            int choix = scanner.nextInt();
            scanner.nextLine();


            switch(choix){
                case 1:
                   Personne.ajouter();
                    break;
                case 2:
                    Personne.afficher();
                    break;
                case 3:
                    Personne.modifier();
                    break;
                case 4:
                    Personne.rechercher();
                    break;
                case 5:
                    Personne.supprimer();
                    break;
                case 6:
                    continuprogramme=false;
                    System.out.println("au revoir");
                default:
                    System.out.println("choix invalide");
            }

        }

    }

}