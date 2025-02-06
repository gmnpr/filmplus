package ru.jabki.filmplus.model;

public class LikeRequest {

    private Long userId;
    private Long filmId;

    public LikeRequest(final Long userId, final Long filmId) {
        this.userId = userId;
        this.filmId = filmId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}