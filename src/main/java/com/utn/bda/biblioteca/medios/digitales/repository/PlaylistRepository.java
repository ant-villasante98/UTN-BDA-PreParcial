package com.utn.bda.biblioteca.medios.digitales.repository;

import com.utn.bda.biblioteca.medios.digitales.model.entity.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Long> {
}
