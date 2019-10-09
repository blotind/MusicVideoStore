package com.blotind.service;

import com.blotind.model.Genre;
import com.blotind.model.MusicVideo;
import com.blotind.repository.MusicVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicVideoService {

    @Autowired
    private MusicVideoRepository musicVideoRepository;

    public List<MusicVideo> getAllMusicVideos() {
        List<MusicVideo> musicVideos = new ArrayList<>();
        musicVideoRepository.findAll().forEach(musicVideos::add);
        return musicVideos;
    }

    public MusicVideo getMusicVideo(long musicVideoId) {
        return musicVideoRepository.findById(musicVideoId).orElseGet(MusicVideo::new);
    }

    public void updateMusicVideo(long musicVideoId, MusicVideo musicVideo) {
        musicVideoRepository.save(musicVideo);
    }

    public void deleteMusicVideo(long musicVideoId) {
        musicVideoRepository.deleteById(musicVideoId);
    }

    public void addMusicVideos(List<MusicVideo> musicVideos) {
        musicVideos.stream().forEach(mv -> addMusicVideo(mv));
    }

    public MusicVideo addMusicVideo(MusicVideo musicVideo) {
        //Could check the releaseYear here and compare it to the current date and disallow if the date is in the future??
        return musicVideoRepository.save(musicVideo);
    }

    public List<MusicVideo> getMusicVideosByGenre(String genre) {
        Genre matchedGenre = Genre.valueOf(genre);
        return musicVideoRepository.findMusicVideoByGenre(matchedGenre);
    }

    public List<MusicVideo> getMusicVideosBySubgenre(String subgenre) {
        return musicVideoRepository.findMusicVideoBySubgenresIsLike(subgenre);
    }

}
