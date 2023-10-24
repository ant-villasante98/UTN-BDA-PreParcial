package com.utn.bda.biblioteca.medios.digitales.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tracks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrackEntity {
    @Id
    @Column(name = "trackid")
    private Long id;

    private String name;

    private String composer;

    private Long milliseconds;

    private Long bytes;

    @Column(name = "unitprice")
    private float unitPrice;

    @OneToMany(mappedBy = "trackEntity")
    private List<InvoiceItemEntity>  invoiceItemEntities;

    @ManyToOne
    @JoinColumn(name = "albumid",referencedColumnName = "albumid")
    private AlbumEntity albumEntity;

    @ManyToOne
    @JoinColumn(name = "genreid", referencedColumnName = "genreid")
    private GenreEntity genreEntity;

    @ManyToOne
    @JoinColumn(name = "mediatypeid",referencedColumnName = "mediatypeid")
    private MediaTypeEntity mediaTypeEntity;

    @ManyToMany(mappedBy = "playlistTrack")
    private List<PlaylistEntity> trackPlaylist;


    public void deletePlaylistAssociation(PlaylistEntity playlist){
        this.trackPlaylist.remove(playlist);
        playlist.getPlaylistTrack().remove(this);
    }

    public void addPlaylistAssociation(PlaylistEntity playlist){
        this.trackPlaylist.add(playlist);
        playlist.getPlaylistTrack().add(this);
    }
}
