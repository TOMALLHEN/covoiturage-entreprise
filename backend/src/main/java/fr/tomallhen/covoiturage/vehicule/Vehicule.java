package fr.tomallhen.covoiturage.vehicule;

import fr.tomallhen.covoiturage.auth.Salarie;
import fr.tomallhen.covoiturage.trajet.Trajet;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "vehicules")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicule")
    private Long idVehicule;

    @Column(name = "marque")
    private String marque;

    @Column(name = "modele")
    private String modele;

    @Column(name = "places_passagers")
    private Integer placesPassagers;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_salarie", nullable = false)
    private Salarie proprietaire;

    @OneToMany(mappedBy = "vehicule")
    private List<Trajet> trajets = new ArrayList<>();
}
