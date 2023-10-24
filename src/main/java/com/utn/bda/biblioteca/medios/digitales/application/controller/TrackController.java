package com.utn.bda.biblioteca.medios.digitales.application.controller;

import com.utn.bda.biblioteca.medios.digitales.application.ResponseHandler;
import com.utn.bda.biblioteca.medios.digitales.application.request.CreateTrackRequest;
import com.utn.bda.biblioteca.medios.digitales.model.dto.TrackDto;
import com.utn.bda.biblioteca.medios.digitales.service.contract.TrackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tracks")
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<TrackDto> trackDtos = this.trackService.getAll();
        return ResponseHandler.success(trackDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id){
        TrackDto trackDto;
        try {
            trackDto = this.trackService.getById(id);
        }catch (Exception exception){
            return ResponseHandler.badRequest("No se pudo encontrar el recurso");
        }
        return ResponseHandler.success(trackDto);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateTrackRequest trackRequest){
        TrackDto trackDto = TrackDto.from(trackRequest);
        try{
            trackDto = this.trackService.save(trackDto);
        }catch (Exception exception){
            return ResponseHandler.badRequest("No se pudo crear el recurso");
        }
        return ResponseHandler.created(trackDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable  long id){
        try {
            this.trackService.delete(id);
        }catch ( Exception exception){
            exception.printStackTrace();
            return ResponseHandler.badRequest("No se pudo borrar el recurso");
        }
        return ResponseHandler.noContent();
    }


}
