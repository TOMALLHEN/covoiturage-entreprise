package fr.tomallhen.covoiturage.trajet;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrajetRepository extends JpaRepository<Trajet, Long> {

    List<Trajet> findByConducteur_IdSalarie(Long idSalarie);

    boolean existsByVehicule_IdVehicule(Long idVehicule);
}
