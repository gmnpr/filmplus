package ru.jabki.filmplus.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.jabki.filmplus.exception.BadRequestException;
import ru.jabki.filmplus.model.Film;
import ru.jabki.filmplus.model.Genre;
import ru.jabki.filmplus.model.LikeRequest;
import ru.jabki.filmplus.model.User;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private static final HashSet<Film> films = new HashSet<>();

    private final UserService userService;

    public FilmService(final UserService userService) {
        this.userService = userService;
    }

    public Film create(final Film film) {
        validate(film);
        film.setId((long) (films.size() + 1));
        film.setLikes(new HashSet<>());
        films.add(film);
        return film;
    }

    public Film getById(final Long id) {
        final Film film = films.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
        if (film == null) {
            throw new BadRequestException(String.format("Фильм с id %d не найден", id));
        }
        return film;
    }

    public Film update(final Film film) {
        validate(film);
        final Film existFilm = getById(film.getId());
        existFilm.setTitle(film.getTitle());
        existFilm.setDescription(film.getDescription());
        existFilm.setReleaseDate(film.getReleaseDate());
        existFilm.setDuration(film.getDuration());
        existFilm.setGenre(film.getGenre());
        return existFilm;
    }

    public void delete(final Long id) {
        films.remove(getById(id));
    }

    public Set<Film> search(final String title, final Genre genre) {
        return films.stream()
                .filter(
                        el -> el.getTitle().equalsIgnoreCase(title) && el.getGenre() == genre
                )
                .collect(Collectors.toCollection(HashSet::new));
    }

    public void like(final LikeRequest request) {
        if (request.getUserId() == null || request.getFilmId() == null) {
            throw new BadRequestException("Необходимо заполнить все данные!");
        }
        final User user = userService.getById(request.getUserId());
        final Film film = getById(request.getFilmId());
        film.getLikes().stream()
                .filter(el -> el.getId().equals(request.getUserId()))
                .findFirst().ifPresent(el -> {throw new BadRequestException("Пользователь уже лайкнул этот фильм!");});
        film.getLikes().add(user);
    }

    private void validate(final Film film) {
        if (film == null) {
            throw new BadRequestException("Введите информацию о фильме");
        }
        if (!StringUtils.hasText(film.getTitle())) {
            throw new BadRequestException("Укажите название фильма");
        }
        if (!StringUtils.hasText(film.getDescription())) {
            throw new BadRequestException("Укажите описание фильма");
        }
        if (film.getReleaseDate() == null) {
            throw new BadRequestException("Необходимо заполнить дату выхода фильма");
        }
        if (film.getDuration() == null) {
            throw new BadRequestException("Укажите продолжительность фильма");
        }
        if (film.getGenre() == null) {
            throw new BadRequestException("Укажите жанр фильма");
        }
    }
}