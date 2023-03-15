package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.dto.AuthorInfoRequest;
import peaksoft.dto.AuthorInfoResponse;
import peaksoft.dto.RegisterRequest;
import peaksoft.entity.AuthInfo;
import peaksoft.jwt.JwtUtil;
import peaksoft.repository.AuthInfoRepository;
import peaksoft.service.AuthInfoService;

import java.util.NoSuchElementException;

/**
 * sequrityFull
 * 2023
 * macbook_pro
 **/
@Service
@RequiredArgsConstructor
public class AuthInfoServiceImpl implements AuthInfoService {
    private final AuthInfoRepository authInfoRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthorInfoResponse register(RegisterRequest request) {
        if (authInfoRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException(
                    String.format("User with email : %s already exists",
                            request.getEmail()));
        }
        AuthInfo build = AuthInfo.builder()
                .email(request.getEmail())
                .role(request.getRole())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        authInfoRepository.save(build);
        String token = jwtUtil.generateToken(build);
        return AuthorInfoResponse.builder()
                .token(token)
                .email(build.getEmail())
                .build();
    }


    @Override
    public AuthorInfoResponse authenticate(AuthorInfoRequest authorInfoRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authorInfoRequest.getEmail(),
                        authorInfoRequest.getPassword()
                )
        );
        AuthInfo authInfo = authInfoRepository.findByEmail(authorInfoRequest.getEmail())
                .orElseThrow(()-> new NoSuchElementException("User with email : %s already exists"));
                String token = jwtUtil.generateToken(authInfo);

        return AuthorInfoResponse.builder()
                .token(token)
                .email(authInfo.getEmail())
                .build();
    }
}
