package com.utn.bda.biblioteca.medios.digitales.application.request;

import com.utn.bda.biblioteca.medios.digitales.model.dto.ManagerEmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateEmployeeRequest {
    private String lastName;

    private String firstName;

    private String title;

    private LocalDateTime birthDate;

    private LocalDateTime hireDate;

    private String address;

    private String city;

    private String state;

    private String country;

    private String postalCode;

    private String phone;

    private String fax;

    private String email;

    private Long reportsTo;

}
