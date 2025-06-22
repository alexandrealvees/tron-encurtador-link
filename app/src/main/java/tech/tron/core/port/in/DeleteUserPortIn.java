package tech.tron.core.port.in;

import tech.tron.core.domain.User;

import java.util.UUID;

public interface DeleteUserPortIn {
    void execute(UUID userId);
}
