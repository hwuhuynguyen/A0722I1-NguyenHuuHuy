package com.service;

import com.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    void deleteSong(int id);

    Song findSongById(int id);
}
