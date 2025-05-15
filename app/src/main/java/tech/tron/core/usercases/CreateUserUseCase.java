package tech.tron.core.usercases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tech.tron.core.domain.User;
import tech.tron.core.port.in.CreateUserPortIn;
import tech.tron.core.port.out.UserRepositoryPortOut;

@Component
public class CreateUserUseCase implements CreateUserPortIn {

    private static final Logger logger = LoggerFactory.getLogger(CreateUserUseCase.class);

    private final UserRepositoryPortOut userRepositoryPortOut;

    public CreateUserUseCase(UserRepositoryPortOut userRepositoryPortOut) {
        this.userRepositoryPortOut = userRepositoryPortOut;
    }

    @Override
    public User execute(User user) {

        logger.info("Creating user {}", user.getEmail());

        var userCreated = userRepositoryPortOut.save(user);

        logger.info("User created {}", user.getUserId());

        return userCreated;
    }
}
