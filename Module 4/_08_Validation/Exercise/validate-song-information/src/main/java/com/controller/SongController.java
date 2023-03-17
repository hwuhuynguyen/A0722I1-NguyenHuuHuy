package com.controller;

import com.model.Song;
import com.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/home")
    public ModelAndView getHomePage() {
        return new ModelAndView("/index", "musics", songService.findAll());
    }

    @GetMapping("/create-music")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/create", "music", new Song());
    }

    @PostMapping("/create-music")
    public ModelAndView saveMusic(@Valid @ModelAttribute ("music") Song song, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/create");
        } else {
            songService.save(song);
            ModelAndView modelAndView = new ModelAndView("/create");
            modelAndView.addObject("music", new Song());
            modelAndView.addObject("message", "Song created successfully");
            return modelAndView;
        }
    }

    @GetMapping("/edit-music/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Song song = songService.findSongById(id);
        ModelAndView modelAndView;
        if (song != null) {
            modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("music", song);
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;

    }
    @PostMapping("/edit-music")
    public ModelAndView updateMusic(@Valid @ModelAttribute ("music") Song song,BindingResult bindingResult ){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/edit");
        }else {
            songService.save(song);
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("music", new Song());
            modelAndView.addObject("message", "Song updated successfully");
            return modelAndView;
        }
    }
}
