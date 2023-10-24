package com.utn.bda.biblioteca.medios.digitales.application.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistTrackRequest {
    private Long playlistId;
    private List<Long> trackIdList;
}


