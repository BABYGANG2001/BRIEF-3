public class Utilisateur extends Personne {
    private String email;
    private String motDePasse;
    private Rôle rôle;

    public Utilisateur(int id, String nom, int age, String email, String motDePasse, Rôle rôle) {
        super(id, nom, age);
        this.email = email;
        this.motDePasse = motDePasse;
        this.rôle = rôle;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Rôle getRôle() { return rôle; }
    public void setRôle(Rôle rôle) { this.rôle = rôle; }
}
