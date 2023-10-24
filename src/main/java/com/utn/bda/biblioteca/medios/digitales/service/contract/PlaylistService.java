package com.utn.bda.biblioteca.medios.digitales.service.contract;

import com.utn.bda.biblioteca.medios.digitales.model.dto.PlaylistDto;
import com.utn.bda.biblioteca.medios.digitales.model.dto.TrackDto;

import java.util.List;

public interface PlaylistService extends Service<PlaylistDto,Long>{

    void deleteTrackFromPlaylist( PlaylistDto playlistDto);

    void associationTrackToPlaylist(PlaylistDto playlistDto);

    List<TrackDto> trackListByPlaylist(Long idPlaylist);
}
