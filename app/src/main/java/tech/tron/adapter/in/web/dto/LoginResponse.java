package tech.tron.adapter.in.web.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}