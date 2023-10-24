package com.utn.bda.biblioteca.medios.digitales.application.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateTrackRequest {
    private String name;

    private String composer;

    private Long milliseconds;

    private Long bytes;

    private float unitPrice;

    private Long albumId;

    private Long mediaTypeId;

    private Long genreId;
}
