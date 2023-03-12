package com.oro.model1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class CarPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    private BigDecimal unitPrice;

    private int amount;

    @ManyToOne
    private Category category;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carPart", cascade = CascadeType.ALL)
    private List<CarModel> carModelList;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carPart", cascade = CascadeType.ALL)
    private List<Transaction> transactionList;
}
