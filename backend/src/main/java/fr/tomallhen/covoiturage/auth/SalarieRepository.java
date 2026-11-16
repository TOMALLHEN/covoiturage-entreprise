package fr.tomallhen.covoiturage.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SalarieRepository extends JpaRepository<Salarie, Long> {
    Optional<Salarie> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdSalarieNot(String email, Long idSalarie);
}
