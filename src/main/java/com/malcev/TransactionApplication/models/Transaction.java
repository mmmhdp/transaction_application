package com.malcev.TransactionApplication.models;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Long trId;
    private Long trCustomerId;
    @CsvBindByPosition(position = 0)
    private String trDatetime;
    @CsvBindByPosition(position = 1)
    private Long trMssCodeType;
    @CsvBindByPosition(position = 2)
    private Long trType;
    @CsvBindByPosition(position = 3)
    private Long trAmount;
    @CsvBindByPosition(position = 4)
    private Long trTerminalId;

    public Transaction(Long trCustomerId, String trDatetime, Long trMssCodeType, Long trType, Long trAmount, Long trTerminalId) {
        this.trCustomerId = trCustomerId;
        this.trDatetime = trDatetime;
        this.trMssCodeType = trMssCodeType;
        this.trType = trType;
        this.trAmount = trAmount;
        this.trTerminalId = trTerminalId;
    }
}
