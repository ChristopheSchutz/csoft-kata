package com.csoft.kata.spotify.classic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlaylistTestWithMockito {

    private static final String MY_PLAYLIST = "My Playlist";
    private static final String PLAYLIST_NOT_FOUND = "Playlist not found";
    private static final String SONG_NOT_FOUND = "Song not found";

    PlaylistRepository playlistRepository;
    SongRepository songRepository;

    @BeforeEach
    public void setUp() {
        playlistRepository = Mockito.mock(PlaylistRepository.class);
        songRepository = Mockito.mock(SongRepository.class);
    }

    @Test
    void should_create_playlist() {
        var createPlayListUseCase = new CreatePlaylistUseCase(playlistRepository);
        var playlistId = createPlayListUseCase.create(MY_PLAYLIST);

        verify(playlistRepository).save(Mockito.any(Playlist.class));
        assertThat(playlistId).isNotNull();
    }

    @Test
    void should_add_song_to_playlist() {
        var addSongToPlaylistUseCase = new AddSongToPlaylistUseCase(playlistRepository, songRepository);

        var playlist = Mockito.mock(Playlist.class);
        when(playlist.getId()).thenReturn(UUID.randomUUID());
        when(playlistRepository.findById(playlist.getId())).thenReturn(Optional.of(playlist));

        var song = Mockito.mock(Song.class);
        when(songRepository.findById(song.getId())).thenReturn(Optional.of(song));

        addSongToPlaylistUseCase.addSong(playlist.getId(), song.getId());

        verify(playlistRepository).findById(playlist.getId());
        verify(songRepository).findById(song.getId());
        verify(playlist).addSong(song);
        verify(playlistRepository).save(playlist);
    }

    @Test
    void should_throw_exception_when_playlist_not_exist() {
        var sut = new AddSongToPlaylistUseCase(playlistRepository, songRepository);

        var throwable = Assertions.assertThrows(IllegalArgumentException.class, () ->
                sut.addSong(UUID.randomUUID(), UUID.randomUUID()));
        assertThat(throwable.getMessage()).isEqualTo(PLAYLIST_NOT_FOUND);
    }

    @Test
    void should_throw_exception_when_song_not_exist() {
        when(playlistRepository.findById(Mockito.any())).thenReturn(Optional.of(new Playlist(MY_PLAYLIST)));

        var sut = new AddSongToPlaylistUseCase(playlistRepository, songRepository);

        var throwable = Assertions.assertThrows(IllegalArgumentException.class, () ->
                sut.addSong(UUID.randomUUID(), UUID.randomUUID()));
        assertThat(throwable.getMessage()).isEqualTo(SONG_NOT_FOUND);
    }
}
