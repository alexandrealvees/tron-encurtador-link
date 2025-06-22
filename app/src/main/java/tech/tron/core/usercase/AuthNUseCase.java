package tech.tron.core.usercase;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;
import tech.tron.adapter.in.web.dto.LoginRequest;
import tech.tron.adapter.in.web.dto.LoginResponse;
import tech.tron.core.port.in.AuthnPortIn;
import tech.tron.core.port.out.UserRepositoryPortOut;
import tech.tron.exception.LoginException;

import java.time.Instant;

@Component
public class AuthNUseCase implements AuthnPortIn {

    private final UserRepositoryPortOut userRepository;
    private final JwtEncoder jwtEncoder;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthNUseCase(UserRepositoryPortOut userRepository,
                        JwtEncoder jwtEncoder,
                        BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.jwtEncoder = jwtEncoder;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public LoginResponse execute(LoginRequest req) {

        var user = this.userRepository.findByEmail(req.email())
                .orElseThrow(LoginException::new);

        var isPasswordValid = bCryptPasswordEncoder.matches(req.password(), user.getPassword());

        if (!isPasswordValid) {
            throw new LoginException();
        }

        var expiresIn = 300L;
        var claims = JwtClaimsSet.builder()
                .subject(user.getUserId().toString())
                .issuer("link-shortener")
                .claim("email", user.getEmail())
                .expiresAt(Instant.now().plusSeconds(expiresIn))
                .build();

        var tokenJwt = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponse(tokenJwt, expiresIn);
    }
}