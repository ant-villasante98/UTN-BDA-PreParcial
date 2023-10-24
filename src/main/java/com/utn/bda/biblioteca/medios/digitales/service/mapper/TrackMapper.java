package com.utn.bda.biblioteca.medios.digitales.service.mapper;

import com.utn.bda.biblioteca.medios.digitales.model.dto.TrackDto;
import com.utn.bda.biblioteca.medios.digitales.model.entity.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TrackMapper implements Mapper<TrackDto, TrackEntity>{
    @Override
    public TrackDto toDto(TrackEntity model) {
        return new TrackDto(
                model.getId(),
                model.getName(),
                model.getComposer(),
                model.getMilliseconds(),
                model.getBytes(),
                model.getUnitPrice(),
                model.getAlbumEntity().getId(),
                model.getMediaTypeEntity().getId(),
                model.getGenreEntity().getId()
        );
    }

    @Override
    public TrackEntity toEntity(TrackDto model) {
        return new TrackEntity(
            model.getId(),
            model.getName(),
            model.getComposer(),
            model.getMilliseconds(),
            model.getBytes(),
            model.getUnitPrice(),
            Collections.emptyList(),
            AlbumEntity.builder().id(model.getAlbumId()).build(),
            GenreEntity.builder().id(model.getGenreId()).build(),
            MediaTypeEntity.builder().id(model.getMediaTypeId()).build(),
            Collections.emptyList()
        );
    }
}
