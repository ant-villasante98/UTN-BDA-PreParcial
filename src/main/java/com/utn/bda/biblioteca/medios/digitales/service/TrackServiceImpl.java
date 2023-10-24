package com.utn.bda.biblioteca.medios.digitales.service;

import com.utn.bda.biblioteca.medios.digitales.model.dto.TrackDto;
import com.utn.bda.biblioteca.medios.digitales.model.entity.TrackEntity;
import com.utn.bda.biblioteca.medios.digitales.repository.TrackRepository;
import com.utn.bda.biblioteca.medios.digitales.service.contract.TrackService;
import com.utn.bda.biblioteca.medios.digitales.service.mapper.TrackMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepository;
    private final TrackMapper trackMapper;
    public TrackServiceImpl(TrackRepository trackRepository, TrackMapper trackMapper) {
        this.trackRepository = trackRepository;
        this.trackMapper = trackMapper;
    }

    @Override
    public List<TrackDto> getAll() {
        List<TrackEntity> trackEntities = this.trackRepository.findAll();
        return trackEntities.stream()
                .map(trackMapper::toDto)
                .toList();
    }

    @Override
    public TrackDto getById(Long id) {
        Optional<TrackEntity> optionalTrack = this.trackRepository.findById(id);
        return optionalTrack
                .map(trackMapper::toDto)
                .orElseThrow();
    }

    @Override
    public TrackDto save(TrackDto model) {
        Optional<TrackEntity> optionalTrack = Stream.of(model).map(trackMapper::toEntity).findFirst();
        if (optionalTrack.get().getId() == null){
            Optional<Long> maxId = this.trackRepository.findAll().stream().map(TrackEntity::getId).max(Long::compareTo);
            maxId.ifPresent(id -> optionalTrack.get().setId(id+1));
        }
        TrackEntity trackEntity = optionalTrack.orElseThrow();
        this.trackRepository.save(trackEntity);
        return Stream.of(trackEntity).map(trackMapper::toDto).findFirst().orElseThrow();
    }

    @Override
    public void delete(Long id) {

        Optional<TrackEntity> optionalTrack = this.trackRepository.findById(id);
        this.trackRepository.delete(optionalTrack.orElseThrow());
    }
}
