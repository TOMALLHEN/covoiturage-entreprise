package fr.tomallhen.covoiturage.poste;

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
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
        name = "postes",
        uniqueConstraints = @UniqueConstraint(
                name = "uq_postes_service_nom",
                columnNames = {"id_service", "nom"}
        )
)
public class Poste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poste")
    private Long id;

    @Column(nullable = false, length = 80)
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_service", nullable = false)
    private ServiceEntreprise serviceEntreprise;

    protected Poste() {
    }

    public Poste(String nom, ServiceEntreprise serviceEntreprise) {
        this.nom = nom;
        this.serviceEntreprise = serviceEntreprise;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ServiceEntreprise getServiceEntreprise() {
        return serviceEntreprise;
    }

    public void setServiceEntreprise(
            ServiceEntreprise serviceEntreprise
    ) {
        this.serviceEntreprise = serviceEntreprise;
    }
}