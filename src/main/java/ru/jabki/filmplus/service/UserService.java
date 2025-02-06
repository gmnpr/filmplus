package ru.jabki.filmplus.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.jabki.filmplus.exception.BadRequestException;
import ru.jabki.filmplus.model.FriendRequest;
import ru.jabki.filmplus.model.User;

import java.util.HashSet;

@Service
public class UserService {

    private static final HashSet<User> users = new HashSet<>();

    public User create(final User user) {
        validate(user);
        user.setId((long) (users.size() + 1));
        user.setFriends(new HashSet<>());
        users.add(user);
        return user;
    }

    public User getById(final long id) {
        final User user = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        if (user == null) {
            throw new BadRequestException(String.format("Пользователь с id %d не найден", id));
        }
        return user;
    }

    public User update(final User user) {
        validate(user);
        final User existUser = getById(user.getId());
        existUser.setName(user.getName());
        existUser.setEmail(user.getEmail());
        existUser.setLogin(user.getLogin());
        existUser.setBirthday(user.getBirthday());
        return existUser;
    }

    public void addFriend(final FriendRequest request) {
        final User user = getById(request.getId());
        user.getFriends().stream()
                .filter(el -> el.equals(request.getFriendId()))
                .findFirst().ifPresent(el -> {throw new BadRequestException("Пользователи уже дружат!");});
        final User friend = getById(request.getFriendId());
        user.getFriends().add(friend.getId());
        friend.getFriends().add(user.getId());
    }

    public void delete(final Long id) {
        users.remove(getById(id));
    }

    private void validate(final User user) {
        if (user == null) {
            throw new BadRequestException("Введите информацию о пользователе");
        }
        if (!StringUtils.hasText(user.getName())) {
            throw new BadRequestException("Укажите имя пользователя");
        }
        if (!StringUtils.hasText(user.getEmail())) {
            throw new BadRequestException("Необходимо указать адрес электронной почты пользователя");
        }
        if (!StringUtils.hasText(user.getLogin())) {
            throw new BadRequestException("Необходимо заполнить логин");
        }
        if (user.getBirthday() == null) {
            throw new BadRequestException("Необходимо заполнить дату рождения");
        }
    }
}