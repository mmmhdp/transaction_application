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
public class TransactionMccCode {
    @Id
    @CsvBindByPosition(position = 0)
    private Long mccCode;
    @CsvBindByPosition(position = 1)
    private String mccCodeDescription;
}
