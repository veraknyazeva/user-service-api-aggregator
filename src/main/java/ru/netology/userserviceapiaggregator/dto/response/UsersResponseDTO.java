package ru.netology.userserviceapiaggregator.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersResponseDTO {
    @JsonProperty
    private List<UserDTO> users = new ArrayList<>();
}
