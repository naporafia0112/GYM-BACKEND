package com.app.gym.service;

import com.app.gym.model.Pack;
import com.app.gym.repository.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackService {

    @Autowired
    private PackRepository packRepository;

    // Ajouter une offre
    public Pack ajouterOffre(Pack pack) {
        return packRepository.save(pack);
    }

    // Afficher toutes les offres
    public List<Pack> obtenirToutesLesOffres() {
        return packRepository.findAll();
    }

    // Modifier une offre
    public Pack modifierOffre(Long id, Pack packDetails) {
        Optional<Pack> optionalPack = packRepository.findById(id);
        if (optionalPack.isPresent()) {
            Pack pack = optionalPack.get();
            pack.setNomOffre(packDetails.getNomOffre());
            pack.setDureeOffre(packDetails.getDureeOffre());
            pack.setPrixMensuel(packDetails.getPrixMensuel());
            return packRepository.save(pack);
        }
        return null;
    }

    // Supprimer une offre
    public void supprimerOffre(Long id) {
        packRepository.deleteById(id);
    }
    
}
