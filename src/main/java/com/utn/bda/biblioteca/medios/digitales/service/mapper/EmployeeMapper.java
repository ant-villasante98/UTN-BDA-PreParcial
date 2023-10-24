package com.utn.bda.biblioteca.medios.digitales.service.mapper;

import com.utn.bda.biblioteca.medios.digitales.model.dto.EmployeeDto;
import com.utn.bda.biblioteca.medios.digitales.model.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class EmployeeMapper implements Mapper<EmployeeDto, EmployeeEntity>{
    @Override
    public EmployeeDto toDto(EmployeeEntity model) {
        Long reportsToId = null;
        if (model.getReportsTo()!=null ){
            reportsToId = model.getReportsTo().getId();
        }
        return new EmployeeDto(
                model.getId(),
                model.getLastName(),
                model.getFirstName(),
                model.getTitle(),
                model.getBirthDate(),
                model.getHireDate(),
                model.getAddress(),
                model.getCity(),
                model.getState(),
                model.getCountry(),
                model.getPostalCode(),
                model.getPhone(),
                model.getFax(),
                model.getEmail(),
                reportsToId
        );
    }

    @Override
    public EmployeeEntity toEntity(EmployeeDto model) {
        EmployeeEntity reportsTo = null;
        if(model.getReportsTo() != null ){
            reportsTo = EmployeeEntity.builder().id(model.getReportsTo()).build();
        }

        if(model.getId() == null){
            return new EmployeeEntity(
                    model.getLastName(),
                    model.getFirstName(),
                    model.getTitle(),
                    model.getBirthDate(),
                    model.getHireDate(),
                    model.getAddress(),
                    model.getCity(),
                    model.getState(),
                    model.getCountry(),
                    model.getPostalCode(),
                    model.getPhone(),
                    model.getFax(),
                    model.getEmail(),
                    reportsTo,
                    Collections.emptyList()
            );
        }

        return new EmployeeEntity(
                model.getId(),
                model.getLastName(),
                model.getFirstName(),
                model.getTitle(),
                model.getBirthDate(),
                model.getHireDate(),
                model.getAddress(),
                model.getCity(),
                model.getState(),
                model.getCountry(),
                model.getPostalCode(),
                model.getPhone(),
                model.getFax(),
                model.getEmail(),
                reportsTo,
                Collections.emptyList(),
                Collections.emptyList()
        );
    }
}
