package com.service;

import com.model.Song;
import com.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void deleteSong(int id) {
        songRepository.deleteById(id);
    }

    @Override
    public Song findSongById(int id) {
        return songRepository.findById(id).orElse(null);
    }
}
