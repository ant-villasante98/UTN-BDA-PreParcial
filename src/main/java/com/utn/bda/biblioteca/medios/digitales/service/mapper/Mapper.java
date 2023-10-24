package com.utn.bda.biblioteca.medios.digitales.service.mapper;

import jakarta.persistence.Entity;

public interface Mapper <T,E>{
    T toDto(E model);
    E toEntity(T model);
}
