package com.example.springboot.services;


import com.example.springboot.models.Sponsor;
import com.example.springboot.repositories.SponsorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SponsorService implements ISponsorService {
    private SponsorRepository sponsorRepository;

    @Override
    public Sponsor ajouterSponsor(Sponsor sponsor) {
        sponsor.setDateCreation(LocalDate.now());
        sponsor.setDateDerniereModification(LocalDate.now());
        sponsor.setArchived(false);
        sponsor.setBloquerContrat(false);
        return sponsorRepository.save(sponsor);
    }

    @Override
    public List<Sponsor> ajouterSponsors(List<Sponsor> sponsors) {
        if (sponsors == null || sponsors.isEmpty()) {
            return Collections.emptyList();
        }

        for (Sponsor s : sponsors) {
            s.setDateCreation(LocalDate.now());
            s.setDateDerniereModification(LocalDate.now());
            s.setArchived(false);
            s.setBloquerContrat(false);
        }

        return sponsorRepository.saveAll(sponsors);
    }

    @Override
    public Sponsor modifierSponsor(Sponsor sponsor) {
        sponsor.setDateCreation(LocalDate.now());
        return sponsorRepository.save(sponsor);
    }

    @Override
    public void supprimerSponsor(Long idSponsor) {
         if (sponsorRepository.existsById(idSponsor)){
             sponsorRepository.deleteById(idSponsor);
         }
    }

    @Override
    public List<Sponsor> listSponsors() {
        return sponsorRepository.findAll();
    }

    @Override
    public Sponsor recupererSponsor(Long idSponsor) {
        if (idSponsor == null) {
            return null;
        }
            return sponsorRepository.findById(idSponsor).orElse(null);
    }

    @Override
    public Boolean archiverSponsor(Long idSponsor) {
        if (idSponsor == null) {
            return false;
        }

        Optional<Sponsor> opt = sponsorRepository.findById(idSponsor);
        if (opt.isEmpty()) {
            return false;
        }

        Sponsor sponsor = opt.get();
        sponsor.setArchived(true);
        sponsor.setDateDerniereModification(LocalDate.now());
        sponsorRepository.save(sponsor);

        return true;
    }
}
