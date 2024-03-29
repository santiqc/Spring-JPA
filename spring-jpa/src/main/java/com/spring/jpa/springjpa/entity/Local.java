package com.spring.jpa.springjpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "manager")
public class Local {

    @Id
    @SequenceGenerator(
            name = "local_secuence",
            sequenceName = "local_secuence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "local_secuence")
    private Long localId;
    private String name;
    private String floor;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
            /*optional = false*/
    )
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "managerId"

    )
    private Manager manager;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "local_customer_map",
            joinColumns = @JoinColumn(
                    name = "local_id",
                    referencedColumnName = "localId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "customer_id",
                    referencedColumnName = "customerId"
            )
    )
    private List<Customer> customerList;



/*    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "local_id",
            referencedColumnName = "localId"
    )
    private List<Order> orderList;*/


}
