package tech.tron.adapter.in.web.dto;

import tech.tron.core.domain.User;

public record CreateUserRequest(String email,
                                String password,
                                String nickname) {

    public User toDomain(){
        return new User(email, password, nickname);
    }
}
