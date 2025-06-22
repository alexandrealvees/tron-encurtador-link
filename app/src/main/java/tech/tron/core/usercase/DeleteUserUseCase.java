package tech.tron.core.usercase;

import org.springframework.stereotype.Component;
import tech.tron.core.port.in.DeleteUserPortIn;
import tech.tron.core.port.out.UserRepositoryPortOut;
import tech.tron.exception.UserNotFoundException;

import java.util.UUID;

@Component
public class DeleteUserUseCase implements DeleteUserPortIn {

   private final UserRepositoryPortOut userRepositoryPortOut;

    public DeleteUserUseCase(UserRepositoryPortOut userRepositoryPortOut) {
        this.userRepositoryPortOut = userRepositoryPortOut;
    }


    public void execute(UUID userId) {

        userRepositoryPortOut.findById(userId)
                        .orElseThrow(UserNotFoundException::new);
        userRepositoryPortOut.deleteById(userId);
    }



}
