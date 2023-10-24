package com.utn.bda.biblioteca.medios.digitales.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.XSlf4j;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "invoices")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceEntity {

    @Id
    @Column(name = "invoiceid")
    private Long id;

    @Column(name = "invoicedate")
    private LocalDateTime invoiceDate;

    @Column(name = "billingaddress")
    private String billingAddress;

    @Column(name = "billingcity")
    private String billingCity;

    @Column(name = "billingstate")
    private String billingState;

    @Column(name = "billingcountry")
    private String billingCountry;

    @Column(name = "billingpostalcode")
    private String billingPostalCode;

    private Long total;

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "invoiceEntity")
    private List<InvoiceItemEntity> invoiceItemEntities;

}
