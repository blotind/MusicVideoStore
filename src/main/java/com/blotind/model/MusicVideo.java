package com.blotind.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class MusicVideo {

    @Id
    private long id;

    @NotEmpty(message = "title may not be empty")
    private String title;

    //Optional
    private String album;

    @NotEmpty(message = "artist may not be empty")
    private String artist;

    @NotNull(message = "duration may not be null")
    private int duration;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ElementCollection
    @NotEmpty(message = "subgenre may not be empty")
    private List<String> subgenres;

    @NotNull(message = "releaseYear may not be null")
    @Max(2019)
    private int releaseYear;

    public MusicVideo() {
    }

    public MusicVideo(long id, @NotEmpty(message = "title may not be empty") String title, String album, @NotEmpty(message = "artist may not be empty") String artist, @NotEmpty(message = "duration may not be empty") int duration, Genre genre, @NotEmpty(message = "subgenre may not be empty") List<String> subgenres, @NotEmpty(message = "releaseYear may not be empty") int releaseYear) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
        this.subgenres = subgenres;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "MusicVideo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", artist='" + artist + '\'' +
                ", duration=" + duration +
                ", genre=" + genre +
                ", subgenre=" + subgenres +
                ", releaseYear=" + releaseYear +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<String> getSubgenres() {
        return subgenres;
    }

    public void setSubgenres(List<String> subgenres) {
        this.subgenres = subgenres;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
