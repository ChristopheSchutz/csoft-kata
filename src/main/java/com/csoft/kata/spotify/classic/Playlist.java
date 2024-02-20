package com.csoft.kata.spotify.classic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Getter
public class Playlist {

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @OneToMany(targetEntity = Song.class)
    private Collection<Song> songs;

    public Playlist(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.songs = new HashSet<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }
}
