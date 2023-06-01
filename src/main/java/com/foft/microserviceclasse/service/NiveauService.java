package com.foft.microserviceclasse.service;

import com.foft.microserviceclasse.modele.Niveau;
import com.foft.microserviceclasse.repository.NiveauRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class NiveauService {

    @Autowired
    private NiveauRepository niveauRepository;

    public Optional<Niveau> getNiveau(Integer id){
        return niveauRepository.findById(id);
    }

    public List<Niveau> getNiveaux(){
        return niveauRepository.findAll();
    }

    public void deleteNiveau (Integer id){
        niveauRepository.deleteById(id);
    }

    public Niveau saveNiveau ( Niveau niveau){
        Niveau saved = niveauRepository.save(niveau);
        return saved;
    }
    public void  CreateNiveauToDB(String code)
    {
        Niveau niveau=new Niveau();
        niveau.setIntitule(code);
        niveauRepository.save(niveau);
    }
}
