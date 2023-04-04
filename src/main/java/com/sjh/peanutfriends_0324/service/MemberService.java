package com.sjh.peanutfriends_0324.service;

import com.sjh.peanutfriends_0324.domain.Member;
import com.sjh.peanutfriends_0324.domain.Role;
import com.sjh.peanutfriends_0324.repository.MemberRepository;
import com.sjh.peanutfriends_0324.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;

    @Transactional
    public Member addMember(Member member) {
        Optional<Role> role = roleRepository.findByName("ROLE_USER");
        member.addRole(role.get());
        Member saveMember = memberRepository.save(member);
        return saveMember;
    }

    public Member findByEmail(String email){
        return memberRepository.findByEmail(email).
                orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));
    }
}
