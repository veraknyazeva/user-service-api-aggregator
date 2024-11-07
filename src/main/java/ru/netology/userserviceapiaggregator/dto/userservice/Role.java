package ru.netology.userserviceapiaggregator.dto.userservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("roleName")
    private RoleNameEnum roleName;

    public enum RoleNameEnum {
        ROLE_ADMIN,
        ROLE_USER;
    }
}
