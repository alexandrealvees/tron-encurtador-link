package tech.tron.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.tron.adapter.in.web.dto.CreateUserRequest;
import tech.tron.adapter.in.web.dto.CreateUserResponse;
import tech.tron.core.port.in.CreateUserPortIn;

import java.net.URI;

@RestController
@RequestMapping(path = "/users")
public class UserControllerAdapterIn {

    private final CreateUserPortIn createUserPortIn;

    public UserControllerAdapterIn(CreateUserPortIn createUserPortIn) {
        this.createUserPortIn = createUserPortIn;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest req) {

        var userCreated = createUserPortIn.execute(req.toDomain());

        var body = CreateUserResponse.fromDomain(userCreated);

        return ResponseEntity.created(URI.create("/")).body(body);
    }
}