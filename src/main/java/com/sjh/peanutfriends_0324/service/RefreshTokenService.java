package com.sjh.peanutfriends_0324.service;

import com.sjh.peanutfriends_0324.domain.RefreshToken;
import com.sjh.peanutfriends_0324.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public RefreshToken addRefreshToken(RefreshToken refreshToken){
        return refreshTokenRepository.save(refreshToken);
    }

    @Transactional
    public void deleteRefreshToken(String refreshToken) {
        refreshTokenRepository.delete(refreshTokenRepository.findByValue(refreshToken).orElseThrow());
    }


}
