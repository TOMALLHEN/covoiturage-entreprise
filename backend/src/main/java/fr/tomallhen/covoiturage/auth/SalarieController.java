package fr.tomallhen.covoiturage.auth;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/salaries")
public class SalarieController {

    private final SalarieService salarieService;

    public SalarieController(SalarieService salarieService) {
        this.salarieService = salarieService;
    }

    @GetMapping
    public List<SalarieResponse> lister() {
        return salarieService.lister();
    }

    @GetMapping("/{id}")
    public SalarieResponse consulter(@PathVariable Long id) {
        return salarieService.consulter(id);
    }

    @GetMapping("/me")
    public SalarieResponse consulterMonProfil(Principal principal) {
        return salarieService.consulterMonProfil(principal.getName());
    }

    @PutMapping("/me")
    public SalarieResponse modifierMonProfil(
            @Valid @RequestBody SalarieProfilRequest request,
            Principal principal
    ) {
        return salarieService.modifierMonProfil(
                request,
                principal.getName()
        );
    }

    @PutMapping("/{id}/affectation")
    public SalarieResponse modifierAffectation(
            @PathVariable Long id,
            @Valid @RequestBody SalarieAffectationRequest request
    ) {
        return salarieService.modifierAffectation(id, request);
    }
}