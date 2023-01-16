package upload.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public class UploadSongForm {
    private String name;
    private String artist;
    private ArrayList<String> type;
    private MultipartFile path;

    public UploadSongForm() {
    }

    public UploadSongForm(String name, String artist, ArrayList<String> type, MultipartFile path) {
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

    public MultipartFile getPath() {
        return path;
    }

    public void setPath(MultipartFile path) {
        this.path = path;
    }
}
