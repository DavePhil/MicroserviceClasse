package com.foft.microserviceclasse.service;

import com.foft.microserviceclasse.modele.Specialite;
import com.foft.microserviceclasse.repository.SpecialiteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class SpecialiteService {

    @Autowired
    private SpecialiteRepository specialiteRepository;

    public Optional<Specialite> getSpecialite(Integer id){
        return specialiteRepository.findById(id);
    }

    public List<Specialite> getspecialites(){return specialiteRepository.findAll();}

    public Iterable<Specialite> getSpecialites(){
        return specialiteRepository.findAll();
    }

    public void deleteSpecialite (Integer id){
        specialiteRepository.deleteById(id);
    }

    public Specialite saveSpecialite (Specialite specialite){
        Specialite savedSpecialite = specialiteRepository.save(specialite);
        return savedSpecialite;
    }
}
