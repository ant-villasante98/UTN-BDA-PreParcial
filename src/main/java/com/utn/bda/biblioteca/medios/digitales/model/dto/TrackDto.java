package com.utn.bda.biblioteca.medios.digitales.model.dto;


import com.utn.bda.biblioteca.medios.digitales.application.request.CreateTrackRequest;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrackDto {
    private Long id;

    private String name;

    private String composer;

    private Long milliseconds;

    private Long bytes;

    private float unitPrice;

    private Long albumId;

    private Long mediaTypeId;

    private Long genreId;

    public static TrackDto from(CreateTrackRequest trackRequest){
        return new TrackDto(
                null,
                trackRequest.getName(),
                trackRequest.getComposer(),
                trackRequest.getMilliseconds(),
                trackRequest.getBytes(),
                trackRequest.getUnitPrice(),
                trackRequest.getAlbumId(),
                trackRequest.getMediaTypeId(),
                trackRequest.getGenreId()
        );
    }
}
