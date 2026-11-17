package fr.tomallhen.covoiturage.participation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {

    List<Participation> findBySalarie_IdSalarie(Long idSalarie);

    List<Participation> findByTrajet_IdTrajet(Long idTrajet);

    Optional<Participation> findBySalarie_IdSalarieAndTrajet_IdTrajet(
            Long idSalarie,
            Long idTrajet
    );
}
