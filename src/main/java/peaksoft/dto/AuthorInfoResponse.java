package peaksoft.dto;

import lombok.*;

/**
 * sequrityFull
 * 2023
 * macbook_pro
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorInfoResponse   {
       private String email;
       private String token;
}
