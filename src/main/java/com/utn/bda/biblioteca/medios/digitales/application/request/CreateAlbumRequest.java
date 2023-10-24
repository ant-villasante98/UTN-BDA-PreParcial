package com.utn.bda.biblioteca.medios.digitales.application.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAlbumRequest {
    private String title;

    private Long artistId;
}
