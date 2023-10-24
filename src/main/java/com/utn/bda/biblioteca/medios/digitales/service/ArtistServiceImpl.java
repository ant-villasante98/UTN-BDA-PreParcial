package com.utn.bda.biblioteca.medios.digitales.service;

import com.utn.bda.biblioteca.medios.digitales.model.dto.ArtistDto;
import com.utn.bda.biblioteca.medios.digitales.model.entity.ArtistEntity;
import com.utn.bda.biblioteca.medios.digitales.repository.ArtistRepository;
import com.utn.bda.biblioteca.medios.digitales.service.contract.ArtistService;
import com.utn.bda.biblioteca.medios.digitales.service.mapper.ArtistMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;
    public ArtistServiceImpl(ArtistRepository artistRepository, ArtistMapper artistMapper) {
        this.artistRepository = artistRepository;
        this.artistMapper = artistMapper;
    }

    @Override
    public List<ArtistDto> getAll() {
        List<ArtistEntity> artistEntities = this.artistRepository.findAll();
        return artistEntities.stream()
                .map(artistMapper::toDto)
                .toList();
    }

    @Override
    public ArtistDto getById(Long id) {
        return null;
    }

    @Override
    public ArtistDto save(ArtistDto model) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
