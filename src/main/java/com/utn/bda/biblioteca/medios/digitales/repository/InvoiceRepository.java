package com.utn.bda.biblioteca.medios.digitales.repository;

import com.utn.bda.biblioteca.medios.digitales.model.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity,Long> {
}
