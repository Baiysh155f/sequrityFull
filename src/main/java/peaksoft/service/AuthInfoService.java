package peaksoft.service;

import peaksoft.dto.AuthorInfoRequest;
import peaksoft.dto.AuthorInfoResponse;
import peaksoft.dto.RegisterRequest;

/**
 * sequrityFull
 * 2023
 * macbook_pro
 **/
public interface AuthInfoService {

    AuthorInfoResponse register(RegisterRequest request);
    AuthorInfoResponse authenticate(AuthorInfoRequest authorInfoRequest);
}
