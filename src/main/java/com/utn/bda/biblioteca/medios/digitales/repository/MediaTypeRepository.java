package com.utn.bda.biblioteca.medios.digitales.repository;

import com.utn.bda.biblioteca.medios.digitales.model.entity.MediaTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaTypeRepository extends JpaRepository<MediaTypeEntity,Long> {
}
