package com.project.instagramclone.model.service;

import com.project.instagramclone.common.EmailCodeService;
import com.project.instagramclone.model.dto.User;
import com.project.instagramclone.model.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailCodeService emailCodeService;

    public boolean 이메일중복체크기능(String email) {
        // TODO E : userMapper 를 이용해서 이메일 중복 여부를 boolean 으로 반환
        return userMapper.이메일중복체크(email) > 0;   // TODO E-1: 메서드명, 인자, 비교연산자
    }

    public boolean 회원가입(User user) {

        // TODO F-1 : 이메일 중복이면 즉시 false 반환
        if (이메일중복체크기능(user.getEmail())) return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));   // passwordEncoder 사용
        userMapper.회원가입(user);
        return true;
    }

    // TODO G-1 : 인증번호 발송
    public void 인증번호발송(String email) {
        emailCodeService.인증번호발송(email);    // emailCodeService 의 기능 호출
    }

    // TODO G-2 : 인증번호 검증 (boolean 반환)
    public boolean 인증번호검증(String email, String code) {
        return emailCodeService.인증번호확인(email, code);
    }
}
