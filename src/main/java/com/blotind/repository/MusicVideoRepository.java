package com.blotind.repository;

import com.blotind.model.Genre;
import com.blotind.model.MusicVideo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicVideoRepository extends CrudRepository<MusicVideo, Long> {
    List<MusicVideo> findMusicVideoByGenre(Genre genre);
    List<MusicVideo> findMusicVideoBySubgenresIsLike(String subGenre);
}
