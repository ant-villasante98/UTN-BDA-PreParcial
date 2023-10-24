package com.utn.bda.biblioteca.medios.digitales.repository;

import com.utn.bda.biblioteca.medios.digitales.model.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<ArtistEntity,Long> {
}
