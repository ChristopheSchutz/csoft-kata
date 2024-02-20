package com.csoft.kata.spotify.classic;

import java.util.UUID;

public class CreatePlaylistUseCase {

    private final PlaylistRepository playlistRepository;

    public CreatePlaylistUseCase(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public UUID create(String name) {
        var playlist = new Playlist(name);
        playlistRepository.save(playlist);
        return playlist.getId();
    }
}
