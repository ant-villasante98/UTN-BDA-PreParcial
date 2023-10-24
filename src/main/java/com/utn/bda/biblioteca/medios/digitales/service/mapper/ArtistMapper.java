package com.utn.bda.biblioteca.medios.digitales.service.mapper;

import com.utn.bda.biblioteca.medios.digitales.model.dto.ArtistDto;
import com.utn.bda.biblioteca.medios.digitales.model.entity.ArtistEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ArtistMapper implements Mapper<ArtistDto, ArtistEntity>{
    @Override
    public ArtistDto toDto(ArtistEntity model) {
        return new ArtistDto(
                model.getId(),
                model.getName()
        );
    }

    @Override
    public ArtistEntity toEntity(ArtistDto model) {
        return new ArtistEntity(
                model.getId(),
                model.getTitle(),
                Collections.emptyList()
        );
    }
}
