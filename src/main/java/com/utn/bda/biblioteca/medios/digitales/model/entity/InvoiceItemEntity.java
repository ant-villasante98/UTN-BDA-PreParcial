package com.utn.bda.biblioteca.medios.digitales.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "invoice_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceItemEntity {
    @Id
    @Column(name = "invoicelineid")
    private Long id;

    @Column(name = "unitprice")
    private Float unitPrice;

    private long quantity;

    @ManyToOne
    @JoinColumn(name = "invoiceid",  referencedColumnName = "invoiceid")
    private InvoiceEntity invoiceEntity;

    @ManyToOne
    @JoinColumn(name = "trackid",referencedColumnName = "trackid")
    private TrackEntity trackEntity;

}
