package tech.tron.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.tron.adapter.in.web.dto.LoginRequest;
import tech.tron.adapter.in.web.dto.LoginResponse;
import tech.tron.core.usercase.AuthNUseCase;

@RestController
public class TokenControllerAdapterIn {

    private final AuthNUseCase authNUseCase;

    public TokenControllerAdapterIn(AuthNUseCase authNUseCase) {
        this.authNUseCase = authNUseCase;
    }

    @PostMapping(value = "/oauth/token")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) {
        var resp = authNUseCase.execute(req);
        return ResponseEntity.ok(resp);
    }
}