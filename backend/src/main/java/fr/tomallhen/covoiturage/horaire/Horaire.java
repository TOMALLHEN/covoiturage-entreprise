package fr.tomallhen.covoiturage.horaire;

import fr.tomallhen.covoiturage.serviceentreprise.ServiceEntreprise;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table(name = "horaires")

public class Horaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horaire")
    private Long id;

    @Column(nullable = false, length = 80)
    private String libelle;

    @Column(name = "heure_debut", nullable = false)
    private LocalTime heureDebut;

    @Column(name = "heure_fin", nullable = false)
    private LocalTime heureFin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_service", nullable = false)
    private ServiceEntreprise serviceEntreprise;

    protected Horaire() {
    }

    public Horaire(
            String libelle,
            LocalTime heureDebut,
            LocalTime heureFin,
            ServiceEntreprise serviceEntreprise
    ) {
        this.libelle = libelle;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.serviceEntreprise = serviceEntreprise;
    }

    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public ServiceEntreprise getServiceEntreprise() {
        return serviceEntreprise;
    }

    public void setServiceEntreprise(ServiceEntreprise serviceEntreprise) {
        this.serviceEntreprise = serviceEntreprise;
    }
}