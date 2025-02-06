package ru.jabki.filmplus.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Film {

    private Long id;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private Integer duration;
    private Genre genre;
    private Set<User> likes;

    public Film(final Long id,
                final String title,
                final String description,
                final LocalDate releaseDate,
                final Integer duration,
                final Genre genre
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.genre = genre;
        this.likes = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }
}