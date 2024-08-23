package com.example.patientmanager.service;

import com.example.patientmanager.model.Medication;
import com.example.patientmanager.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    public Medication saveMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    public Optional<Medication> findById(Long id) {
        return medicationRepository.findById(id);
    }

    public void deleteMedication(Long id) {
        medicationRepository.deleteById(id);
    }

    public List<Medication> getMedicationsByUserId(Long userId) {
        return medicationRepository.findByUserId(userId);
    }
}