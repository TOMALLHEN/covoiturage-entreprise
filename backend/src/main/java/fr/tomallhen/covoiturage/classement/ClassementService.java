package fr.tomallhen.covoiturage.classement;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClassementService {

    public List<ClassementResponse> consulter() {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Calcul du classement à implémenter"
        );
    }
}