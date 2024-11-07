package ru.netology.userserviceapiaggregator.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.netology.userserviceapiaggregator.dto.response.UserDTO;
import ru.netology.userserviceapiaggregator.dto.response.UsersResponseDTO;
import ru.netology.userserviceapiaggregator.dto.userservice.User;
import ru.netology.userserviceapiaggregator.integration.HttpRestClient;

import java.util.List;

@Service
public class UserService {
    private final HttpRestClient restClient;

    public UserService(@Qualifier("httpRestClientImpl") HttpRestClient restClient) {
        this.restClient = restClient;
    }

    public UsersResponseDTO getAllUsers() {
        List<User> users = restClient.getUsers();
        UsersResponseDTO usersResponseDTO = new UsersResponseDTO();

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(user.getEmail());
            userDTO.setName(user.getName());
            userDTO.setRole(user.getRole().getRoleName().toString());
            usersResponseDTO.getUsers().add(userDTO);
        }

        return usersResponseDTO;
    }
}
