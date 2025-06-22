package tech.tron.core.port.in;

import tech.tron.adapter.in.web.dto.LoginRequest;
import tech.tron.adapter.in.web.dto.LoginResponse;

public interface AuthnPortIn {

    LoginResponse execute(LoginRequest req);
}