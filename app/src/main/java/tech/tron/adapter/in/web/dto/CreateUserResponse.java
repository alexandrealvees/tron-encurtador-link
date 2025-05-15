package tech.tron.adapter.in.web.dto;

import tech.tron.core.domain.User;

import java.time.LocalDateTime;

public record CreateUserResponse(String userId,
                                 LocalDateTime createdAt) {

    public static CreateUserResponse fromDomain(User user){
        return new CreateUserResponse(user.getUserId().toString(), user.getCreatedAt());
    }
}
