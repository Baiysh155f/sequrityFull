package peaksoft.dto;

import lombok.*;

/**
 * sequrityFull
 * 2023
 * macbook_pro
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorInfoRequest{
       private String email;
       private String password;
}
