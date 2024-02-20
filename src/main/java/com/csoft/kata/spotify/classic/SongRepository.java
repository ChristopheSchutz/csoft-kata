package com.csoft.kata.spotify.classic;

import java.util.Optional;
import java.util.UUID;

public interface SongRepository {

    void save(Song song);

    Optional<Song> findById(UUID id);
}
