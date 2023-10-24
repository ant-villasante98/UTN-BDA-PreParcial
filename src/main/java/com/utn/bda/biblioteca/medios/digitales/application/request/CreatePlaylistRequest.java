package com.utn.bda.biblioteca.medios.digitales.application.request;

import com.utn.bda.biblioteca.medios.digitales.model.dto.TrackDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePlaylistRequest {
    private String name;
    private List<TrackDto> trackList;
}
