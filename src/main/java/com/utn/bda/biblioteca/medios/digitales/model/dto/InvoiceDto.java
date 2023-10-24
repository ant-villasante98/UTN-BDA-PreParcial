package com.utn.bda.biblioteca.medios.digitales.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceDto {
    private Long id;

    private LocalDateTime invoiceDate;

    private String billingAddress;

    private String billingCity;

    private String billingState;

    private String billingCountry;

    private String billingPostalCode;

    private Long total;
}
