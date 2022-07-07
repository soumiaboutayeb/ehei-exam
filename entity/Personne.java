
import javax.persistence.*;

@Entity
@Table(name = "personne")
public class Personne {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "CIN", unique = true)
    private String CIN;
    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    public Personne() {
    }

    public Personne(String CIN, String nom, String prenom) {
        this.CIN = CIN;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
