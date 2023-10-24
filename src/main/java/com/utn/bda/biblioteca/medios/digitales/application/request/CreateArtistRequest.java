package com.utn.bda.biblioteca.medios.digitales.application.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateArtistRequest {
    private long id;

    private String title;
}
