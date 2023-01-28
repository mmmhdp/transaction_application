package com.malcev.TransactionApplication.models.DTO;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransactionAvgDayResultsDto {
    @Id
    private Long avgAmount;
    private String day;
    private String mssCode;
    private String mssCodeCounter;
}
