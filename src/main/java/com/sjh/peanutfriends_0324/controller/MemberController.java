package com.sjh.peanutfriends_0324.controller;

import com.sjh.peanutfriends_0324.domain.Member;
import com.sjh.peanutfriends_0324.domain.Role;
import com.sjh.peanutfriends_0324.dto.MemberLoginDto;
import com.sjh.peanutfriends_0324.dto.MemberSignUpResponseDto;
import com.sjh.peanutfriends_0324.dto.MemberSingUpDto;
import com.sjh.peanutfriends_0324.service.MemberService;
import com.sun.net.httpserver.HttpsServer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;
    private final Jwt

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody @Valid MemberSingUpDto memberSingUpDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Member member = new Member();
        member.setEmail(memberSingUpDto.getEmail());
        member.setName(memberSingUpDto.getName());
        member.setPassword(member.getPassword());

        Member saveMember = memberService.addMember(member);

        MemberSignUpResponseDto memberSignUpResponseDto = new MemberSignUpResponseDto();

        memberSignUpResponseDto.setMemberId(saveMember.getMemberId());
        memberSignUpResponseDto.setEmail(saveMember.getEmail());
        memberSignUpResponseDto.setName(saveMember.getName());
        memberSignUpResponseDto.setRegdate(saveMember.getRegdate());

        return new ResponseEntity(memberSignUpResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid MemberLoginDto loginDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Member member = memberService.findByEmail(loginDto.getEmail());
        if(loginDto.getPassword() != member.getPassword()){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        List<String> roles = member.getRoles().stream().map(Role::getName).collect(Collectors.toList());

        String accessToken = jwtTokenizer


    }
}
