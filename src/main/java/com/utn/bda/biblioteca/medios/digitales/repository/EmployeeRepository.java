package com.utn.bda.biblioteca.medios.digitales.repository;

import com.utn.bda.biblioteca.medios.digitales.model.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
