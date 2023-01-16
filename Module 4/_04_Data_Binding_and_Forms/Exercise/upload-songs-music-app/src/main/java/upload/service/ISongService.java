package upload.service;

import upload.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    boolean checkContentType(String contentType);
}
