package ru.jabki.filmplus.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.jabki.filmplus.exception.BadRequestException;
import ru.jabki.filmplus.model.Review;
import ru.jabki.filmplus.model.ReviewRequest;

import java.util.HashSet;

@Service
public class ReviewService {

    private static final HashSet<Review> reviews = new HashSet<>();

    private final FilmService filmService;
    private final UserService userService;

    public ReviewService(final FilmService filmService, final UserService userService) {
        this.filmService = filmService;
        this.userService = userService;
    }

    public Review create(final ReviewRequest request) {
        validate(request);
        final Review review = new Review(
                (long) (reviews.size() + 1),
                filmService.getById(request.getFilmId()),
                userService.getById(request.getUserId()),
                request.getText()
        );
        reviews.add(review);
        return review;
    }

    private void validate(final ReviewRequest request) {
        if (request == null) {
            throw new BadRequestException("Необходимо указать данные рецензии");
        }
        if (request.getUserId() == null) {
            throw new BadRequestException("Необходимо указать идентификатор пользователя");
        }
        if (request.getFilmId() == null) {
            throw new BadRequestException("Необходимо указать идентификатор фильма");
        }
        if (!StringUtils.hasText(request.getText())) {
            throw new BadRequestException("Необходимо добавить тексте рценезии");
        }
    }
}