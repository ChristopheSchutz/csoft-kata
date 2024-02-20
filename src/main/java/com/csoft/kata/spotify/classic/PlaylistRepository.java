package com.csoft.kata.spotify.classic;

import java.util.Optional;
import java.util.UUID;

public interface PlaylistRepository {

    void save(Playlist playlist);

    Optional<Playlist> findById(UUID id);
}
