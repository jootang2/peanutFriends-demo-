package com.sjh.peanutfriends_0324.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class RefreshTokenDto {
    @NotEmpty
    String refreshToken;
}
