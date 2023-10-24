package com.utn.bda.biblioteca.medios.digitales.model.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private Long id;

    private String lastName;

    private String firstName;

    private String company;

    private String address;

    private String city;

    private String state;

    private String country;

    private String postalCode;

    private String phone;

    private String fax;

    private String email;

}
