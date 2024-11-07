package ru.netology.userserviceapiaggregator.integration.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.netology.userserviceapiaggregator.dto.userservice.User;
import ru.netology.userserviceapiaggregator.integration.HttpRestClient;

import java.util.Arrays;
import java.util.List;

@Component
public class HttpRestClientImpl implements HttpRestClient {

    @Value("${user-service.url}")
    private String userServiceUrl;
    private final RestTemplate restTemplate;

    public HttpRestClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers() {
        ResponseEntity<User[]> responseEntity =
                restTemplate.getForEntity(userServiceUrl, User[].class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return Arrays.asList(responseEntity.getBody());
        } else {
            String message =
                    String.format("Упс, что-то пошло не так! " +
                            "Получили неуспешный ответ от user-service. " +
                            "HTTP STATUS: %s", responseEntity.getStatusCode());
            throw new RuntimeException(message);
        }
    }
}
