package fr.tomallhen.covoiturage.horaire;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/horaires")
public class HoraireController {

    private final HoraireService horaireService;

    public HoraireController(HoraireService horaireService) {
        this.horaireService = horaireService;
    }

    @GetMapping
    public List<HoraireResponse> lister() {
        return horaireService.lister();
    }

    @GetMapping("/{id}")
    public HoraireResponse consulter(@PathVariable Long id) {
        return horaireService.consulter(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HoraireResponse creer(@Valid @RequestBody HoraireRequest request) {
        return horaireService.creer(request);
    }

    @PutMapping("/{id}")
    public HoraireResponse modifier(
            @PathVariable Long id,
            @Valid @RequestBody HoraireRequest request
    ) {
        return horaireService.modifier(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimer(@PathVariable Long id) {
        horaireService.supprimer(id);
    }
}