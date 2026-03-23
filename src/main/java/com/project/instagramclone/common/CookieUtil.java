package com.project.instagramclone.common;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component // service controller처럼 이름을 규정지어 만든 것이 아니라
// 개발자가 필요로 해서 만든 자바 클래스 파일
public class CookieUtil {
    /**
     * Todo : new Cookie(name, value)로 쿠키 객체를 생성하세요.
     * Todo : setHttpOnly(true) — JS 접근 차단 (XSS 방어)
     * Todo : setPath("/") — 모든 경로에서 사용 가능하도록 설정
     * Todo : setMaxAge(maxAgeSeconds) — 유지 시간 설정
     * Todo : res.addCookie(cookie) — 응답에 추가
     */
    public void add(HttpServletResponse req, String name, String value, int maxAgeSeconds) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(maxAgeSeconds);
        req.addCookie(cookie);
    }

    /**
     * Todo : 빈 값(""으로 쿠키를 생성하고 setMaxAge(0)으로 즉시 삭제되도록 설정하세요.
     * Todo : setPath("/")를 반드시 설정하세요. (원래 쿠키와 경로가 일치해야 삭제됩니다.)
     */
    public void delete(HttpServletResponse req, String name) {
        Cookie cookie = new Cookie(name, "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        req.addCookie(cookie);

    }

    /**
     * Todo : req.getCookies()로 쿠키 배열을 가져오고, null이면 즉시 null을 반환하세요.
     */
    public String get(HttpServletResponse req, String name) {
        Cookie[] cookies =req.getCookies();
        if (cookies == null) return null;

        return Arrays.stream()
    }
}

