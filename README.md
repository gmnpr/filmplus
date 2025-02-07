# FilmPlus

## Цель проекта

Filmorate предназначен для создания рекомендаций и предложений фильмов на основе оценок и предпочтений пользователей.

## TODO`s
### Часть I

### Минимум
- Расширить модель User полями login и birthday (обязательные поля)
- Реализовать enum Genre, сделать хардкод базовых жанров (COMEDY, HORROR ..)
- Реализовать модель Film (id, name, description, releaseDate, duration, genres), все поля являются обязательными
- Реализовать FilmController, который позволят создавать новый фильм, редактировать существующий, получать фильм по идентификатору и удалять его
- Реализовать "Поиск фильмов" (подсказка - RequestParam)

### Продвинутый уровень (тоже обязательно, но я пойму если тут возникнет много вопросов и трудностей. Жабки, это нормально)
- Пользователь может добавить другого пользователя в друзья
- Пользователь может написать отзыв про фильм
- Пользователь может поставить фильму лайк

### Часть II

- Переосмыслить модели (если это необходимо)
- Удалить удаление :)
- Переезд на Lombok
- Реализация всех необходимых репозиториев
- Unit тесты