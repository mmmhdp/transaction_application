package com.malcev.TransactionApplication.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
    private String trDatetime;
    private Long trMssCodeType;
    private Long trType;
    private Long trAmount;
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
