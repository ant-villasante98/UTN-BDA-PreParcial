package com.utn.bda.biblioteca.medios.digitales.service.contract;

import java.util.List;

public interface Service<T,E> {
    List<T> getAll();

    T getById(E id);

    T save(T model);

    void delete(E id);
}
