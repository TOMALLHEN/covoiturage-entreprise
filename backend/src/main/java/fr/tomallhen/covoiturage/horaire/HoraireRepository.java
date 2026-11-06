package fr.tomallhen.covoiturage.horaire;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HoraireRepository extends JpaRepository<Horaire, Long> {
}