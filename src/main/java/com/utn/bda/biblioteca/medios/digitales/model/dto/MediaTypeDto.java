package com.utn.bda.biblioteca.medios.digitales.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaTypeDto {
    private Long id;

    private String name;

}
