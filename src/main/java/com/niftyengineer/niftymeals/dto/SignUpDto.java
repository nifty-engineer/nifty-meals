package com.niftyengineer.niftymeals.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {

    @NotEmpty
    private String fullName;

    @NotEmpty
    private String userEmail;

    @NotEmpty
    private char[] password;

}
