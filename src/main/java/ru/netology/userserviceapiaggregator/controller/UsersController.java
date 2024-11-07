package ru.netology.userserviceapiaggregator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.userserviceapiaggregator.dto.response.UsersResponseDTO;
import ru.netology.userserviceapiaggregator.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UsersController {
    private final UserService service;

    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public UsersResponseDTO getAllUsers(){
        return service.getAllUsers();
    }
}
