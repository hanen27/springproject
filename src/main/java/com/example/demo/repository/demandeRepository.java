package com.example.demo.repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Demande;
@Repository
public interface demandeRepository extends JpaRepository<Demande, Long> {
    List<Demande> findAllBySalarieeId(Long salarieeId);
    //Optional<Demande> findByIdDemandeAndSalarieeId(Long id_demande, Long salairee_id);


}
