package com.utn.bda.biblioteca.medios.digitales.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "media_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaTypeEntity {

    @Id
    @Column(name = "mediatypeid")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "mediaTypeEntity")
    private List<TrackEntity> trackEntities;
}
