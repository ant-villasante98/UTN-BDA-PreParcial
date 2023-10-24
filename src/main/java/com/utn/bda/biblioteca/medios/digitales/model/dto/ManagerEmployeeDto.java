package com.utn.bda.biblioteca.medios.digitales.model.dto;

import com.utn.bda.biblioteca.medios.digitales.model.entity.EmployeeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerEmployeeDto {

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

    public static ManagerEmployeeDto from(EmployeeEntity employeeEntity){
        if (employeeEntity != null) {

            return new ManagerEmployeeDto(
                    employeeEntity.getId(),
                    employeeEntity.getLastName(),
                    employeeEntity.getFirstName(),
                    employeeEntity.getTitle(),
                    employeeEntity.getBirthDate(),
                    employeeEntity.getHireDate(),
                    employeeEntity.getAddress(),
                    employeeEntity.getCity(),
                    employeeEntity.getState(),
                    employeeEntity.getCountry(),
                    employeeEntity.getPostalCode(),
                    employeeEntity.getPhone(),
                    employeeEntity.getFax(),
                    employeeEntity.getEmail()
            );
        }
        return null;
    }

}
