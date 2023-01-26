package com.malcev.TransactionApplication.repository;

import com.malcev.TransactionApplication.models.GenderTrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenderTrainRepository extends JpaRepository<GenderTrain, Long>{
}
