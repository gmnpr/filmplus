package ru.jabki.filmplus.model;

public class ReviewRequest {

    private Long id;
    private Long filmId;
    private Long userId;
    private String text;

    public ReviewRequest(final Long id, final Long filmId, final Long userId, final String text) {
        this.id = id;
        this.filmId = filmId;
        this.userId = userId;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public Long getFilmId() {
        return filmId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public void setText(String text) {
        this.text = text;
    }
}