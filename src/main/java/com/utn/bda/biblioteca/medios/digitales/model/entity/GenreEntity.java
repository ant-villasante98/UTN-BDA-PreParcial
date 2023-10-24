package com.utn.bda.biblioteca.medios.digitales.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "genres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreEntity {
    @Id
    @Column(name = "genreid")
    private long id;

    private String name;

    @OneToMany(mappedBy = "genreEntity")
    private List<TrackEntity> trackEntities;
}
