package com.tpxsports.tpxsports.domains;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "rankme")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String steam;

    private String name;

    private Integer kills;

    private Integer deaths;

    private Integer assists;

    @Transient
    private BigDecimal kd;

}
