package com.utn.bda.biblioteca.medios.digitales.model.dto;

import com.utn.bda.biblioteca.medios.digitales.application.request.PlaylistTrackRequest;
import com.utn.bda.biblioteca.medios.digitales.application.request.CreatePlaylistRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaylistDto {
    private Long id;
    private String name;
    private List<TrackDto> trackList;

    public static PlaylistDto from(CreatePlaylistRequest playlistRequest){
        List<TrackDto> trackDtos = Collections.emptyList();
        if(playlistRequest.getTrackList() !=null){
            trackDtos =playlistRequest.getTrackList();
        }
        return  new PlaylistDto(
                null,
                playlistRequest.getName(),
                trackDtos
        );
    }

    public static PlaylistDto from(PlaylistTrackRequest addTrackToPlaylist){

        List<TrackDto> trackDtos = addTrackToPlaylist.getTrackIdList().stream()
                .map(idTrack ->TrackDto.builder().id(idTrack).build())
                .toList();
        return PlaylistDto.builder()
                .id(addTrackToPlaylist.getPlaylistId())
                .trackList(trackDtos).build();
    }
}
