package ru.netology.userserviceapiaggregator.integration;

import ru.netology.userserviceapiaggregator.dto.userservice.User;

import java.util.List;

public interface HttpRestClient {
    List<User> getUsers();
}
