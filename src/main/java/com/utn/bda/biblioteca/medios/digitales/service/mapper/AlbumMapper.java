package com.utn.bda.biblioteca.medios.digitales.service.mapper;

import com.utn.bda.biblioteca.medios.digitales.model.dto.AlbumDto;
import com.utn.bda.biblioteca.medios.digitales.model.entity.AlbumEntity;
import com.utn.bda.biblioteca.medios.digitales.model.entity.ArtistEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class AlbumMapper implements Mapper<AlbumDto, AlbumEntity> {
    @Override
    public AlbumDto toDto(AlbumEntity model) {
        return new AlbumDto(
                model.getId(),
                model.getTitle(),
                model.getArtistEntity().getId()
        );

    }

    @Override
    public AlbumEntity toEntity(AlbumDto model) {
        return new AlbumEntity(
                model.getId(),
                model.getTitle(),
                Collections.emptyList(),
                ArtistEntity.builder().id(model.getArtistId()).build()
        );
    }
}
