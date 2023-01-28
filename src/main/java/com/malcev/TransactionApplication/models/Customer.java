package com.malcev.TransactionApplication.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long customerId;
    private String name;
    private String surname;
    private String password;

    public Customer(String name, String surname, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
    }
}
