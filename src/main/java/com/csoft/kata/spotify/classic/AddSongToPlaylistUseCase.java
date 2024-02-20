package com.csoft.kata.spotify.classic;

import java.util.UUID;

public class AddSongToPlaylistUseCase {

    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;

    public AddSongToPlaylistUseCase(PlaylistRepository playlistRepository, SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    public void addSong(UUID playlistId, UUID songId) {
        var playlist = playlistRepository.findById(playlistId).orElseThrow(() -> new IllegalArgumentException("Playlist not found"));
        var song = songRepository.findById(songId).orElseThrow(() -> new IllegalArgumentException("Song not found"));
        playlist.addSong(song);
        playlistRepository.save(playlist);
    }
}
