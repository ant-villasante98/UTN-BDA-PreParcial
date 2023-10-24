package com.utn.bda.biblioteca.medios.digitales.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "albums")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlbumEntity {
    @Id
    @Column(name = "albumid")
    private Long id;

    private String title;

    @OneToMany(mappedBy = "albumEntity")
    private List<TrackEntity> trackEntities;

    @ManyToOne
    @JoinColumn(name = "artistid",referencedColumnName = "artistid")
    private ArtistEntity artistEntity;
}
