package com.sjh.peanutfriends_0324.security.jwt.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class LoginUserDto {
    private Long memberId;
    private String email;
    private List<String> roles = new ArrayList<>();

    public void addRole(String role){
        roles.add(role);
    }
}
