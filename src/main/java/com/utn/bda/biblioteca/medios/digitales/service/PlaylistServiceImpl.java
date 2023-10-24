package com.utn.bda.biblioteca.medios.digitales.service;

import com.utn.bda.biblioteca.medios.digitales.model.dto.PlaylistDto;
import com.utn.bda.biblioteca.medios.digitales.model.dto.TrackDto;
import com.utn.bda.biblioteca.medios.digitales.model.entity.PlaylistEntity;
import com.utn.bda.biblioteca.medios.digitales.model.entity.TrackEntity;
import com.utn.bda.biblioteca.medios.digitales.repository.PlaylistRepository;
import com.utn.bda.biblioteca.medios.digitales.repository.TrackRepository;
import com.utn.bda.biblioteca.medios.digitales.service.contract.PlaylistService;
import com.utn.bda.biblioteca.medios.digitales.service.mapper.PlaylistMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final TrackRepository trackRepository;
    private final PlaylistMapper playlistMapper;
    public PlaylistServiceImpl(PlaylistRepository playlistRepository, TrackRepository trackRepository, PlaylistMapper playlistMapper) {
        this.playlistRepository = playlistRepository;
        this.trackRepository = trackRepository;
        this.playlistMapper = playlistMapper;
    }

    @Override
    public List<PlaylistDto> getAll() {
        List<PlaylistEntity> playlistEntities = this.playlistRepository.findAll();
        return playlistEntities.stream()
                .map(playlistMapper::toDto)
                .toList();
    }

    @Override
    public PlaylistDto getById(Long id) {
        Optional<PlaylistEntity> optionalPlaylist = this.playlistRepository.findById(id);
        return optionalPlaylist.map(playlistMapper::toDto).orElseThrow();
    }

    @Override
    public PlaylistDto save(PlaylistDto model) {
        Optional<PlaylistEntity> optionalPlaylist = Stream.of(model).map(playlistMapper::toEntity).findFirst();
        if(optionalPlaylist.get().getId() ==null){
            Optional<Long> maxId = this.playlistRepository.findAll().stream().map(PlaylistEntity::getId).max(Long::compareTo);
            maxId.ifPresent(id -> optionalPlaylist.get().setId(id+1));
        }
        PlaylistEntity playlistEntity = optionalPlaylist.orElseThrow();
        this.playlistRepository.save(playlistEntity);
        return Stream.of(playlistEntity).map(playlistMapper::toDto).findFirst().orElseThrow();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteTrackFromPlaylist( PlaylistDto playlistDto) {
        Optional<PlaylistEntity> playlistEntity = this.playlistRepository.findById(playlistDto.getId());
        if(playlistEntity.isPresent()) {
            for (TrackDto track : playlistDto.getTrackList()) {
                Optional<TrackEntity> optionaltrackEntity = this.trackRepository.findById(track.getId());
                TrackEntity trackEntity = optionaltrackEntity.orElseThrow();
                trackEntity.deletePlaylistAssociation(playlistEntity.orElseThrow());
                this.trackRepository.save(trackEntity);
            }
        }


    }

    @Override
    public void associationTrackToPlaylist(PlaylistDto playlistDto) {
        Optional<PlaylistEntity> playlistEntity = this.playlistRepository.findById(playlistDto.getId());
        if(playlistEntity.isPresent()) {
            //
            // Hay problema de PK cuando el track ya existe en la asociacion con la playlist
            for (TrackDto track : playlistDto.getTrackList()) {
                Optional<TrackEntity> optionaltrackEntity = this.trackRepository.findById(track.getId());
                TrackEntity trackEntity = optionaltrackEntity.orElseThrow();
                trackEntity.addPlaylistAssociation(playlistEntity.orElseThrow());
                this.trackRepository.save(trackEntity);
            }
        }
    }

    @Override
    public List<TrackDto> trackListByPlaylist(Long idPlaylist) {
        PlaylistDto playlistDto = this.getById(idPlaylist);

        return playlistDto.getTrackList();
    }


}
