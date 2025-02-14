package com.app.gym.controller;

import com.app.gym.model.Pack;
import com.app.gym.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packs")
@CrossOrigin(origins = "http://localhost:4200")
public class PackController {

    @Autowired
    private PackService packService;

    // Ajout d'une offre
    @PostMapping
    public Pack ajouterPack(@RequestBody Pack pack) {
        return packService.ajouterOffre(pack);
    }

    // Obtention de toutes les offres
    @GetMapping
    public List<Pack> obtenirTousLesPacks() {
        return packService.obtenirToutesLesOffres();
    }

    // Modification
    @PutMapping("/{id}")
    public Pack modifierPack(@PathVariable Long id, @RequestBody Pack pack) {
        return packService.modifierOffre(id, pack);
    }
    
        // Suppression

    @DeleteMapping("/{id}")
    public void supprimerPack(@PathVariable Long id) {
        packService.supprimerOffre(id);
    }
}