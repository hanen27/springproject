package com.example.demo.controller;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Demande;
import com.example.demo.model.Salariee;
import com.example.demo.repository.demandeRepository;
import com.example.demo.repository.salarieeRepository;

@RestController
@RequestMapping("/demande")
public class DemandeController {
@Autowired
private demandeRepository demandeRepository;
@Autowired
private salarieeRepository salarieeRepository;

@GetMapping("/all/{salarieeId}")

public List<Demande> getAllDemandesBySalaarieId(@PathVariable Long salarieeId ) {
	return demandeRepository.findAllBySalarieeId(salarieeId);
}
@PostMapping("/createdemande/{salarieeid}")
public Demande createDemande(@PathVariable Long salarieeid,@RequestBody Demande demande) {
	Salariee s = salarieeRepository.findById(salarieeid).get();
	demande.setSalariee(s);
	return demandeRepository.save(demande);
}
@PutMapping("/{demandeId}")
public Demande updateDemande(@PathVariable  Long demandeId,
                              @RequestBody Demande demandeRequest) {
    Optional<Demande> optionalDemande = demandeRepository.findById(demandeId);
    if (!optionalDemande.isPresent()) {
        throw new ResourceNotFoundException("error");
    }



    optionalDemande.get().setDate_debut(demandeRequest.getDate_debut());
    optionalDemande.get().setDate_fin(demandeRequest.getDate_fin());
    optionalDemande.get().setType(demandeRequest.getType());

    return demandeRepository.save(optionalDemande.get());

    
    

  
}

}



