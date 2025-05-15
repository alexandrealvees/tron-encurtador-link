package tech.tron.core.port.in;

import tech.tron.core.domain.User;

public interface CreateUserPortIn {

    User execute(User user);
}
