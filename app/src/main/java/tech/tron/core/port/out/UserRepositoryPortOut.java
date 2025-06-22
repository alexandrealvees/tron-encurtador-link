package tech.tron.core.port.out;

import tech.tron.core.domain.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPortOut {

    User save(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findById(UUID userId);

    void deleteById(UUID userId);
}
