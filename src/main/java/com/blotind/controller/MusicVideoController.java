package com.blotind.controller;

import com.blotind.model.MusicVideo;
import com.blotind.service.MusicVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusicVideoController {

    @Autowired
    private MusicVideoService musicVideoService;

    /*
    Get all Music Videos
     */
    @GetMapping("/musicVideos")
    public List<MusicVideo> getAllMusicVideos() {

        return musicVideoService.getAllMusicVideos();
    }

    /*
    Get a MusicVideo given that specific musicVideoId
     */
    @GetMapping("/musicVideos/{musicVideoId}")
    public MusicVideo getMusicVideo(@PathVariable long musicVideoId) {

        return musicVideoService.getMusicVideo(musicVideoId);
    }

    /*
    Add a single MusicVideo
     */
    @PostMapping("/musicVideo")
    public MusicVideo addMusicVideo(@RequestBody MusicVideo musicVideo) {

        return musicVideoService.addMusicVideo(musicVideo);
    }

    /*
    Add a list of MusicVideos
     */
    @PostMapping("/musicVideos")
    public void addMusicVideos(@RequestBody List<MusicVideo> musicVideos) {

        musicVideoService.addMusicVideos(musicVideos);
    }

    /*
    Update a MusicVideo given that specific musicVideoId
     */
    @PutMapping("/musicVideos")
    public void updateMusicVideo(@RequestParam(name = "musicVideoId") long musicVideoId, @RequestBody MusicVideo musicVideo) {

        musicVideoService.updateMusicVideo(musicVideoId, musicVideo);
    }

    /*
    Delete the MusicVideo with the given key
     */
    @DeleteMapping("/musicVideos/{musicVideoId}")
    public void deleteMusicVideo(@PathVariable long musicVideoId) {

        musicVideoService.deleteMusicVideo(musicVideoId);
    }

    @GetMapping("/musicVideos/byGenre/{genre}")
    public List<MusicVideo> getMusicVideosByGenre(@PathVariable String genre) {

        return musicVideoService.getMusicVideosByGenre(genre);
    }

    @GetMapping("/musicVideos/bySubgenre/{subgenre}")
    public List<MusicVideo> getMusicVideosBySubgenre(@PathVariable String subgenre) {

        return musicVideoService.getMusicVideosBySubgenre(subgenre);
    }
}