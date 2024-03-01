package com.spring.jpa.springjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_customer",
        uniqueConstraints =  @UniqueConstraint(name = "email_adress", columnNames = "email_adress")
)
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_secuence",
            sequenceName = "customer_secuence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_secuence"
    )
    private Long customerId;
    private String firstName;
    private String lastName;
    @Column(
            name = "email_adress",
            nullable = false
    )
    private String email;


    @Embedded
    private Address address;
}
