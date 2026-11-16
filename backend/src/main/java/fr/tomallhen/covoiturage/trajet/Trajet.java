
package fr.tomallhen.covoiturage.trajet;

import fr.tomallhen.covoiturage.auth.Salarie;
import fr.tomallhen.covoiturage.vehicule.Vehicule;
import fr.tomallhen.covoiturage.participation.Participation;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "trajets")
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trajet")
    private Long idTrajet;

    @Column(name = "adresse_depart")
    private String adresseDepart;

    @Column(name = "latitude_depart")
    private Double latitudeDepart;

    @Column(name = "longitude_depart")
    private Double longitudeDepart;

    @Column(name = "adresse_arrivee")
    private String adresseArrivee;

    @Column(name = "latitude_arrivee")
    private Double latitudeArrivee;

    @Column(name = "longitude_arrivee")
    private Double longitudeArrivee;

    @Column(name = "depart_prevu_le")
    private LocalDateTime departPrevuLe;

    @Column(name = "arrivee_prevue_le")
    private LocalDateTime arriveePrevueLe;

    @Column(name = "places_proposees")
    private Integer placesProposees;

    @Column(name = "statut")
    private String statut;

    @Column(name = "termine_le")
    private LocalDateTime termineLe;

    @Column(name = "cree_le")
    private LocalDateTime creeLe;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_salarie", nullable = false)
    private Salarie conducteur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vehicule", nullable = false)
    private Vehicule vehicule;

    @OneToMany(mappedBy = "trajet")
    private List<Participation> participations = new ArrayList<>();

    public Trajet() {
    }

    public Long getIdTrajet() {
        return idTrajet;
    }

    public String getAdresseDepart() {
        return adresseDepart;
    }

    public void setAdresseDepart(String adresseDepart) {
        this.adresseDepart = adresseDepart;
    }

    public Double getLatitudeDepart() {
        return latitudeDepart;
    }

    public void setLatitudeDepart(Double latitudeDepart) {
        this.latitudeDepart = latitudeDepart;
    }

    public Double getLongitudeDepart() {
        return longitudeDepart;
    }

    public void setLongitudeDepart(Double longitudeDepart) {
        this.longitudeDepart = longitudeDepart;
    }

    public String getAdresseArrivee() {
        return adresseArrivee;
    }

    public void setAdresseArrivee(String adresseArrivee) {
        this.adresseArrivee = adresseArrivee;
    }

    public Double getLatitudeArrivee() {
        return latitudeArrivee;
    }

    public void setLatitudeArrivee(Double latitudeArrivee) {
        this.latitudeArrivee = latitudeArrivee;
    }

    public Double getLongitudeArrivee() {
        return longitudeArrivee;
    }

    public void setLongitudeArrivee(Double longitudeArrivee) {
        this.longitudeArrivee = longitudeArrivee;
    }

    public LocalDateTime getDepartPrevuLe() {
        return departPrevuLe;
    }

    public void setDepartPrevuLe(LocalDateTime departPrevuLe) {
        this.departPrevuLe = departPrevuLe;
    }

    public LocalDateTime getArriveePrevueLe() {
        return arriveePrevueLe;
    }

    public void setArriveePrevueLe(LocalDateTime arriveePrevueLe) {
        this.arriveePrevueLe = arriveePrevueLe;
    }

    public Integer getPlacesProposees() {
        return placesProposees;
    }

    public void setPlacesProposees(Integer placesProposees) {
        this.placesProposees = placesProposees;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDateTime getTermineLe() {
        return termineLe;
    }

    public void setTermineLe(LocalDateTime termineLe) {
        this.termineLe = termineLe;
    }

    public LocalDateTime getCreeLe() {
        return creeLe;
    }

    public void setCreeLe(LocalDateTime creeLe) {
        this.creeLe = creeLe;
    }

    public Salarie getConducteur() {
        return conducteur;
    }

    public void setConducteur(Salarie conducteur) {
        this.conducteur = conducteur;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
