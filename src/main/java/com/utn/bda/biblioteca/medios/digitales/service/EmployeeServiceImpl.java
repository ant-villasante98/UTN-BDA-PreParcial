package com.utn.bda.biblioteca.medios.digitales.service;

import com.utn.bda.biblioteca.medios.digitales.model.dto.EmployeeDto;
import com.utn.bda.biblioteca.medios.digitales.model.entity.EmployeeEntity;
import com.utn.bda.biblioteca.medios.digitales.repository.EmployeeRepository;
import com.utn.bda.biblioteca.medios.digitales.service.contract.EmployeeService;
import com.utn.bda.biblioteca.medios.digitales.service.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<EmployeeEntity> employeeEntities = this.employeeRepository.findAll();
        return employeeEntities.stream()
                .map(employeeMapper::toDto)
                .toList();
    }

    @Override
    public EmployeeDto getById(Long id) {
        Optional<EmployeeEntity> employeeEntity = this.employeeRepository.findById(id);

        return employeeEntity.map(employeeMapper::toDto).orElseThrow();
    }

    @Override
    public EmployeeDto save(EmployeeDto model) {

        Optional<EmployeeEntity> employeeEntity = Stream.of(model).map(employeeMapper::toEntity).findFirst();
        if(employeeEntity.get().getId() == null){
            Optional<Long> maxId = this.employeeRepository.findAll().stream().map(EmployeeEntity::getId).max(Long::compareTo);
            maxId.ifPresent(id -> employeeEntity.get().setId(id+1));
        }
        this.employeeRepository.save(employeeEntity.get());

        return Stream.of(employeeEntity.get()).map(employeeMapper::toDto).findFirst().get();
    }

    @Override
    public void delete(Long id) {
        Optional<EmployeeEntity> employeeEntity = this.employeeRepository.findById(id);
            this.employeeRepository.save(employeeEntity.orElseThrow());
    }
}
