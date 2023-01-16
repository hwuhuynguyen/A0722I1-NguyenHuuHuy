package upload.model;

import java.util.ArrayList;

public class Song {
    private String name;
    private String artist;
    private ArrayList<String> type;
    private String path;

    public Song() {
    }

    public Song(String name, String artist, ArrayList<String> type, String path) {
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
