package music.service;

import music.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song update(Song song);

    void delete(int id);

    Song findById(int id);
}
