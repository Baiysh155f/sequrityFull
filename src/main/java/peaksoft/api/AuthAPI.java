package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import peaksoft.dto.AuthorInfoRequest;
import peaksoft.dto.AuthorInfoResponse;
import peaksoft.dto.RegisterRequest;
import peaksoft.service.AuthInfoService;

/**
 * sequrityFull
 * 2023
 * macbook_pro
 **/
@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthAPI {
    private final AuthInfoService authInfoService;
    @PostMapping("/register")
    public AuthorInfoResponse register(@RequestBody RegisterRequest request){
        return authInfoService.register(request);
    }
    @PostMapping("/authenticate")
    public AuthorInfoResponse register(@RequestBody AuthorInfoRequest authorInfoRequest){
        return authInfoService.authenticate(authorInfoRequest);
    }

}
