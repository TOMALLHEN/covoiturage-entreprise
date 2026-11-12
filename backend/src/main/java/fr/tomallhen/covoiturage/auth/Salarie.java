package fr.tomallhen.covoiturage.auth;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import fr.tomallhen.covoiturage.poste.Poste;
import fr.tomallhen.covoiturage.horaire.Horaire;
import fr.tomallhen.covoiturage.vehicule.Vehicule;
import fr.tomallhen.covoiturage.trajet.Trajet;
import fr.tomallhen.covoiturage.participation.Participation;

@Entity
@Table(name = "salaries")
public class Salarie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salarie")
    private Long idSalarie;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "mot_de_passe_hash")
    private String motDePasseHash;

    @Column(name = "role")
    private String role;

    @Column(name = "adresse_domicile")
    private String adresseDomicile;

    @Column(name = "cree_le")
    private LocalDateTime creeLe;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_poste", nullable = false)
    private Poste poste;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_horaire")
    private Horaire horaire;

    @OneToMany(mappedBy = "proprietaire")
    private List<Vehicule> vehicules = new ArrayList<>();

    @OneToMany(mappedBy = "conducteur")
    private List<Trajet> trajets = new ArrayList<>();

    @OneToMany(mappedBy = "salarie")
    private List<Participation> participations = new ArrayList<>();


    public Salarie() {
    }


    public Long getIdSalarie() {
        return idSalarie;
    }

    public void setIdSalarie(Long idSalarie) {
        this.idSalarie = idSalarie;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasseHash() {
        return motDePasseHash;
    }

    public void setMotDePasseHash(String motDePasseHash) {
        this.motDePasseHash = motDePasseHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdresseDomicile() {
        return adresseDomicile;
    }

    public void setAdresseDomicile(String adresseDomicile) {
        this.adresseDomicile = adresseDomicile;
    }

    public LocalDateTime getCreeLe() {
        return creeLe;
    }

    public void setCreeLe(LocalDateTime creeLe) {
        this.creeLe = creeLe;
    }
}
