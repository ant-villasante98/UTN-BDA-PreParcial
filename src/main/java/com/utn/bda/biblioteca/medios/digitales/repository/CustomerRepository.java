package com.utn.bda.biblioteca.medios.digitales.repository;

import com.utn.bda.biblioteca.medios.digitales.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
}
