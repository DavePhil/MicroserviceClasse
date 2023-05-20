package com.foft.microserviceclasse.repository;

import com.foft.microserviceclasse.modele.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialiteRepository extends JpaRepository<Specialite, Integer> {
}
