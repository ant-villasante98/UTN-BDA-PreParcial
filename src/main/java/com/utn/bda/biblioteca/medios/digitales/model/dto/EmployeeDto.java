package com.utn.bda.biblioteca.medios.digitales.model.dto;


import com.utn.bda.biblioteca.medios.digitales.application.request.CreateEmployeeRequest;
import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private Long id;

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

    public  static EmployeeDto from(CreateEmployeeRequest employeeRequest){

        return new EmployeeDto(
                null,
                employeeRequest.getLastName(),
                employeeRequest.getFirstName(),
                employeeRequest.getTitle(),
                employeeRequest.getBirthDate(),
                employeeRequest.getHireDate(),
                employeeRequest.getAddress(),
                employeeRequest.getCity(),
                employeeRequest.getState(),
                employeeRequest.getCountry(),
                employeeRequest.getPostalCode(),
                employeeRequest.getPhone(),
                employeeRequest.getFax(),
                employeeRequest.getEmail(),
                employeeRequest.getReportsTo()
        );

    }

}
