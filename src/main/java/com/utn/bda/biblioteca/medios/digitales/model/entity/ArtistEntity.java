package com.utn.bda.biblioteca.medios.digitales.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "artists")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistEntity {
    @Id
    @Column(name = "artistid")
    private long id;

    private String name;

    @OneToMany(mappedBy = "artistEntity")
    private List<AlbumEntity> albumEntities;
}
