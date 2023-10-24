package com.utn.bda.biblioteca.medios.digitales.repository;

import com.utn.bda.biblioteca.medios.digitales.model.entity.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<TrackEntity,Long> {
}
