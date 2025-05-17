package tech.tron.core.usercases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import tech.tron.core.domain.User;
import tech.tron.core.port.in.CreateUserPortIn;
import tech.tron.core.port.out.UserRepositoryPortOut;

@Component
public class CreateUserUseCase implements CreateUserPortIn {

    private static final Logger logger = LoggerFactory.getLogger(CreateUserUseCase.class);

    private final UserRepositoryPortOut userRepositoryPortOut;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public CreateUserUseCase(UserRepositoryPortOut userRepositoryPortOut,
                             BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepositoryPortOut = userRepositoryPortOut;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User execute(User user) {

        logger.info("Creating user {}", user.getEmail());

        user.encodePassword(bCryptPasswordEncoder);

        var userCreated = userRepositoryPortOut.save(user);

        logger.info("User created {}", user.getUserId());

        return userCreated;
    }
}
