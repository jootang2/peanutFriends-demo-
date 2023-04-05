package com.sjh.peanutfriends_0324.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MemberLoginResponseDto {
    private String accessToken;
    private String refreshToken;

    private Long memberId;
    private String nickname;
}
