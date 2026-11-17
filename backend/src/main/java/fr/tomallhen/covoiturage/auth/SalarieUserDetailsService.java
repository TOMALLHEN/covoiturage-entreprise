package fr.tomallhen.covoiturage.auth;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class SalarieUserDetailsService implements UserDetailsService {

    private final SalarieRepository salarieRepository;

    public SalarieUserDetailsService(SalarieRepository salarieRepository) {
        this.salarieRepository = salarieRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) {
        Salarie salarie = salarieRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Identifiants invalides"
                ));

        return User.withUsername(salarie.getEmail())
                .password(salarie.getMotDePasseHash())
                .roles(salarie.getRole())
                .build();
    }
}