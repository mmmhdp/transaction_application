package com.malcev.TransactionApplication.models;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenderTrain {
    @Id
    @CsvBindByPosition(position = 0)
    private Long CustomerId;
    @CsvBindByPosition(position = 1)
    private String gender;
}
