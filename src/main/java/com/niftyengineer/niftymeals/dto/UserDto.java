package com.niftyengineer.niftymeals.dto;

import com.niftyengineer.niftymeals.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String userEmail;
    private String token;
    private Role role;
}