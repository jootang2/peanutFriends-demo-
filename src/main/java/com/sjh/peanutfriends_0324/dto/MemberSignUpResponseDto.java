package com.sjh.peanutfriends_0324.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberSignUpResponseDto {
    private String name;
    private String email;
    private Long memberId;
    private LocalDateTime regdate;
}
