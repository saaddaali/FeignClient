package com.example.voiture.services;


import com.example.voiture.entites.Voiture;
import com.example.voiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoitureServiceImpl implements VoitureService {
    
    @Autowired
    private VoitureRepository voitureRepository;

    @Override
    public Voiture enregistrerVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }
} 