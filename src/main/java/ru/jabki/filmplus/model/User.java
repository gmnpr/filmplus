package ru.jabki.filmplus.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class User {

    private Long id;
    private String name;
    private String email;
    private String login;
    private LocalDate birthday;
    private Set<Long> friends;

    public User(final Long id,
                final String name,
                final String email,
                final String login,
                final LocalDate birthday
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.birthday = birthday;
        this.friends = new HashSet<>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setFriends(Set<Long> friends) {
        this.friends = friends;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getLogin() {
        return login;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Set<Long> getFriends() {
        return friends;
    }
}