package com.malcev.TransactionApplication.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "gender_train",
        uniqueConstraints = @UniqueConstraint(
                name = "gender_unique",
                columnNames = "gender"
        )
)
public class GenderTrain {
    @Id
    @SequenceGenerator(
            name = "gender_sequence",
            sequenceName = "gender_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gender_sequence"
    )
    private Long genderId;
    @Column(
            name = "gender",
            nullable = false
    )
    private String gender;

    public GenderTrain(String gender) {
        this.gender = gender;
    }
}
