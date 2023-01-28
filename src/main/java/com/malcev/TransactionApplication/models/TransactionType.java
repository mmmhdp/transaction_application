package com.malcev.TransactionApplication.models;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionType {
    @Id
    @CsvBindByPosition(position = 0)
    private Long type;
    @CsvBindByPosition(position = 1)
    private String typeDescription;
}
