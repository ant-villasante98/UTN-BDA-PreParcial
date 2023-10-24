package com.utn.bda.biblioteca.medios.digitales.service.mapper;

import com.utn.bda.biblioteca.medios.digitales.model.dto.PlaylistDto;
import com.utn.bda.biblioteca.medios.digitales.model.entity.PlaylistEntity;
import com.utn.bda.biblioteca.medios.digitales.model.entity.TrackEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PlaylistMapper implements Mapper<PlaylistDto, PlaylistEntity>{
    private final TrackMapper trackMapper;

    public PlaylistMapper(TrackMapper trackMapper) {
        this.trackMapper = trackMapper;
    }

    @Override
    public PlaylistDto toDto(PlaylistEntity model) {
        return new PlaylistDto(
                model.getId(),
                model.getName(),
                model.getPlaylistTrack().stream()
                        .map(trackMapper::toDto)
                        .toList()
        );
    }

    @Override
    public PlaylistEntity toEntity(PlaylistDto model) {
        List<TrackEntity> trackEntities = Collections.emptyList();
        if (model.getTrackList() != null){
            trackEntities = model.getTrackList().stream()
                    .map(trackMapper::toEntity)
                    .toList();
        }

        return new PlaylistEntity(
                model.getId(),
                model.getName(),
                trackEntities
        );
    }
}
