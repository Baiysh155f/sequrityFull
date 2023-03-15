package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import peaksoft.dto.AuthorInfoResponse;
import peaksoft.entity.AuthInfo;

import java.util.Optional;

/**
 * sequrityFull
 * 2023
 * macbook_pro
 **/
public interface AuthInfoRepository extends JpaRepository<AuthInfo,Long> {
    Optional<AuthInfo> findByEmail(String email);
    boolean existsByEmail(String email);
}
