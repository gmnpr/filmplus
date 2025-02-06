package ru.jabki.filmplus.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.jabki.filmplus.model.Film;
import ru.jabki.filmplus.model.Genre;
import ru.jabki.filmplus.service.FilmService;

import java.util.Set;

@RestController
@Tag(name = "Фильмы")
@RequestMapping("/api/v1/film")
public class FilmController {

    private final FilmService filmService;

    public FilmController(final FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping
    @Operation(summary = "Создать новый фильм")
    public Film create(@RequestBody final Film film) {
        return filmService.create(film);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить фильм по id")
    public Film getById(@PathVariable("id") final Long id) {
        return filmService.getById(id);
    }

    @PatchMapping
    @Operation(summary = "Обновление информации о фильме")
    public Film update(@RequestBody final Film film) {
        return filmService.update(film);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление фильма")
    public void delete(@PathVariable final Long id) {
        filmService.delete(id);
    }

    @GetMapping
    @Operation(summary = "Поиск фильмов")
    public Set<Film> search(
            @RequestParam final String title,
            @RequestParam final Genre genre
    ) {
        return filmService.search(title, genre);
    }
}