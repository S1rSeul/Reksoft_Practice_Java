package com.reksoft.exporter.service;

import java.util.List;

public abstract class AbstractApiService<T, D> {

    protected abstract List<D> fetchDtos();

    protected abstract T convert(D dto);

    public List<T> getAll() {
        List<D> dtos = fetchDtos();
        return dtos.stream()
                .map(this::convert)
                .toList();
    }
}