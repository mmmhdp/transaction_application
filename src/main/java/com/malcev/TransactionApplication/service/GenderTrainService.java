package com.malcev.TransactionApplication.service;

import com.malcev.TransactionApplication.models.GenderTrain;
import com.malcev.TransactionApplication.repository.GenderTrainRepository;
import org.springframework.stereotype.Service;

@Service
public class GenderTrainService {
    private final GenderTrainRepository genderTrainRepository;

    public GenderTrainService(GenderTrainRepository genderTrainRepository) {
        this.genderTrainRepository = genderTrainRepository;
    }

    public GenderTrain saveGenderTrain(GenderTrain genderTrainToSave){
        genderTrainRepository.save(genderTrainToSave);
        return genderTrainToSave;
    }
}
