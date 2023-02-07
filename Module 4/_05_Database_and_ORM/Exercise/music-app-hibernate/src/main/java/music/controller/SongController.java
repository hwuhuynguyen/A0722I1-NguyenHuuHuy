package music.controller;

import music.model.Song;
import music.service.ISongService;
import music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("music")
public class SongController {
    @Autowired
    private ISongService songService = new SongService();

    @GetMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("music/home");
        List<Song> songList = songService.findAll();
        modelAndView.addObject("songList", songList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("music/create", "song", new Song());
    }
    @PostMapping("/save")
    public ModelAndView saveSong(@ModelAttribute Song song) {
        Song newSong = new Song(song.getName(), song.getArtist(), song.getType(), song.getPath());
        songService.save(newSong);
        ModelAndView modelAndView = new ModelAndView("music/create");
        modelAndView.addObject("song", new Song());
        modelAndView.addObject("message", "Added new song successfully !");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        Song song = songService.findById(id);
        return new ModelAndView("music/view", "song", song);
    }
    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable int id) {
        Song song = songService.findById(id);
        return new ModelAndView("music/update", "song", song);
    }
    @PostMapping("/updated")
    public ModelAndView update(@ModelAttribute Song song) {
        songService.update(song);
        ModelAndView modelAndView = new ModelAndView("music/update");
        modelAndView.addObject("song", new Song());
        modelAndView.addObject("message", "Updated new song successfully !");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        Song song = songService.findById(id);
        return new ModelAndView("music/delete", "song", song);
    }

    @PostMapping("/deleted")
    public String delete(@ModelAttribute Song song) {
        int id = song.getId();
        songService.delete(id);
        return "redirect:/music";
    }
}
