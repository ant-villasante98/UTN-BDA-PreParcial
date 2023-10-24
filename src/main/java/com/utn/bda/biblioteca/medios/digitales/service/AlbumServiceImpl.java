package com.utn.bda.biblioteca.medios.digitales.service;

import com.utn.bda.biblioteca.medios.digitales.model.dto.AlbumDto;
import com.utn.bda.biblioteca.medios.digitales.model.entity.AlbumEntity;
import com.utn.bda.biblioteca.medios.digitales.repository.AlbumRepository;
import com.utn.bda.biblioteca.medios.digitales.service.contract.AlbumService;
import com.utn.bda.biblioteca.medios.digitales.service.mapper.AlbumMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;
    public AlbumServiceImpl(AlbumRepository albumRepository, AlbumMapper albumMapper) {
        this.albumRepository = albumRepository;
        this.albumMapper = albumMapper;
    }

    @Override
    public List<AlbumDto> getAll() {
        List<AlbumEntity> albumEntities = this.albumRepository.findAll();
        return albumEntities.stream()
                .map(albumMapper::toDto)
                .toList()
                ;
    }

    @Override
    public AlbumDto getById(Long id) {
        return null;
    }

    @Override
    public AlbumDto save(AlbumDto model) {
        Optional<AlbumEntity> albumEntity = Stream.of(model).map(albumMapper::toEntity).findFirst();
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
