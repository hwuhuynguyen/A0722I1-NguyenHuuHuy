package upload.service;

import upload.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongService implements ISongService {
    private final List<Song> songList = new ArrayList<>();
    private static final ArrayList<String> contentTypeList = new ArrayList<>();
    static {
        contentTypeList.add("audio/mpeg");
        contentTypeList.add("video/mp4");
        contentTypeList.add("audio/wav");
        contentTypeList.add("audio/ogg");
        contentTypeList.add("video/ogg");
    }

    @Override
    public List<Song> findAll() {
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }

    @Override
    public boolean checkContentType(String contentType) {
        return !contentTypeList.contains(contentType);
    }
}
