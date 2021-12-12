package com.appitem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name ="items")
public class Item {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int itemId;
    @Column
    private String itemName;
    @Column
    private String itemEnteredByUser;
    @Column
    private Timestamp itemEnteredDate;
    @Column
    private double itemBuyingPrice;
    @Column
    private double itemSellingPrice;
    @Column
    private Timestamp itemLastModifiedDate;
    @Column
    private Timestamp itemLastModifiedByUser;
    @Column
    private Status itemStatus;
}