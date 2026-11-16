package fr.tomallhen.covoiturage.vehicule;

import fr.tomallhen.covoiturage.auth.Salarie;
import fr.tomallhen.covoiturage.trajet.Trajet;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicules")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicule")
    private Long idVehicule;

    @Column(nullable = false)
    private String marque;

    @Column(nullable = false)
    private String modele;

    @Column(name = "places_passagers", nullable = false)
    private Integer placesPassagers;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_salarie", nullable = false)
    private Salarie proprietaire;

    @OneToMany(mappedBy = "vehicule")
    private List<Trajet> trajets = new ArrayList<>();

    protected Vehicule() {
    }

    public Vehicule(
            String marque,
            String modele,
            Integer placesPassagers,
            Salarie proprietaire
    ) {
        this.marque = marque;
        this.modele = modele;
        this.placesPassagers = placesPassagers;
        this.proprietaire = proprietaire;
    }

    public Long getIdVehicule() {
        return idVehicule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Integer getPlacesPassagers() {
        return placesPassagers;
    }

    public void setPlacesPassagers(Integer placesPassagers) {
        this.placesPassagers = placesPassagers;
    }

    public Salarie getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Salarie proprietaire) {
        this.proprietaire = proprietaire;
    }
}