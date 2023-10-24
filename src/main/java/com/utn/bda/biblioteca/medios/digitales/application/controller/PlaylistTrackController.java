package com.utn.bda.biblioteca.medios.digitales.application.controller;

import com.utn.bda.biblioteca.medios.digitales.application.ResponseHandler;
import com.utn.bda.biblioteca.medios.digitales.application.request.PlaylistTrackRequest;
import com.utn.bda.biblioteca.medios.digitales.model.dto.PlaylistDto;
import com.utn.bda.biblioteca.medios.digitales.model.dto.TrackDto;
import com.utn.bda.biblioteca.medios.digitales.service.contract.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/playlisttracks")
public class PlaylistTrackController {

    private final PlaylistService playlistService;


    public PlaylistTrackController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> tracksFromPlaylist(@PathVariable(name = "id") Long idPlaylist){
        try {
            List<TrackDto> trackDtoList = this.playlistService.trackListByPlaylist(idPlaylist);
            return ResponseHandler.success(trackDtoList);
        }catch (Exception exception){
            return ResponseHandler.badRequest("No se pudo encotrar el recurso");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> addAssociationTrackToPlaylist(@PathVariable(name = "id") long playlistId, @RequestBody PlaylistTrackRequest addTrackToPlaylist){
        if (playlistId!=addTrackToPlaylist.getPlaylistId()){
            return ResponseHandler.badRequest("Bad Request");
        }
        try {

            PlaylistDto playlistDto = PlaylistDto.from(addTrackToPlaylist);
            this.playlistService.associationTrackToPlaylist(playlistDto);
            return ResponseHandler.noContent();
        }catch (Exception exception){
            return ResponseHandler.badRequest("Bad Request");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAssociationTrackToPlaylist(@PathVariable(name = "id") long playlistId, @RequestBody PlaylistTrackRequest addTrackToPlaylist){
        if (playlistId!=addTrackToPlaylist.getPlaylistId()){
            return ResponseHandler.badRequest("Bad Request");
        }
        try {

            PlaylistDto playlistDto = PlaylistDto.from(addTrackToPlaylist);
            this.playlistService.deleteTrackFromPlaylist(playlistDto);
            return ResponseHandler.noContent();
        }catch (Exception exception){
            return ResponseHandler.badRequest("Bad Request");
        }
    }
}
