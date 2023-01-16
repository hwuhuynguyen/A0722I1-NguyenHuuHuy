package upload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import upload.model.Song;
import upload.model.UploadSongForm;
import upload.service.ISongService;
import upload.service.SongService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Value("${songs-upload}")
    private String songUpload;

    private final ISongService service = new SongService();

    @GetMapping("")
    public String index(Model model) {
        List<Song> songList = service.findAll();
        model.addAttribute("songs", songList);
        return "index";
    }

    @GetMapping("create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create", "songForm", new UploadSongForm());
        return modelAndView;
    }

    @PostMapping("save")
    public ModelAndView saveSong(@ModelAttribute UploadSongForm songForm) {
        MultipartFile multipartFile = songForm.getPath();
        String contentType = multipartFile.getContentType();
        String fileName = multipartFile.getOriginalFilename();
        /**
         * reference: https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
         *
         * .mp3 -> audio/mpeg
         * .mp4 -> video/mp4
         * .wav -> audio/wav
         * .oga -> audio/ogg
         * .ogv -> video/ogg
         *
         */
        if (service.checkContentType(contentType)) {
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("message", "Invalid file input");
            modelAndView.addObject("songForm", new UploadSongForm());
            return modelAndView;
        } else {
            try {
                FileCopyUtils.copy(songForm.getPath().getBytes(), new File(songUpload + fileName));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            Song song = new Song(songForm.getName(), songForm.getArtist(), songForm.getType(), fileName);
            service.save(song);
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("songForm", songForm);
            modelAndView.addObject("message", "Added new song successfully !");
            return modelAndView;
        }
    }
}
