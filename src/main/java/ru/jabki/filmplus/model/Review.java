package ru.jabki.filmplus.model;

public class Review {

    private Long id;
    private Film film;
    private User user;
    private String text;

    public Review(final Long id, final Film film, final User user, final String text) {
        this.id = id;
        this.film = film;
        this.user = user;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUser(User user) {
        this.user = user;
    }
}