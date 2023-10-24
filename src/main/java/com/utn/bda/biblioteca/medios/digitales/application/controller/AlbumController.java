package com.utn.bda.biblioteca.medios.digitales.application.controller;


import com.utn.bda.biblioteca.medios.digitales.application.ResponseHandler;
import com.utn.bda.biblioteca.medios.digitales.model.dto.AlbumDto;
import com.utn.bda.biblioteca.medios.digitales.service.contract.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<AlbumDto> albumDtos = this.albumService.getAll();
        return ResponseHandler.success(albumDtos);
    }
}
