package com.project.instagramclone.model.mapper;

import com.project.instagramclone.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    // TODO D-1 : 회원가입 메서드 선언
    // 반환타입   메서드이름  (매개변수자료형  매개변수이름)
    void 회원가입(User user);

    // TODO D-2 : 이메일 중복 체크 메서드 선언
    // SQL 에서 COUNT(*) 결과를 받아야 한다. 어떤 자료형?
    int 이메일중복체크(String email); // 인증번호 보내기 전에 DB에 존재하는 이메일인가? 체크

    User 이메일로회원찾기(String email);

    List<User> 모든회원조회();

    List<User> 유저명검색(String keyword);
    /*
    ai가 Param을 추천할 때는 저 파람이 문제가 아니라 service mapper.xml controller의 문제일 가능성이 99.99%

    결론 @Param이 보이면.. 이 친구가 몰랐구나.. 조용히 타인신고
    Param은 mapper.xml에서 작성한 #{ } 내부값과 자바에서 전달하는 변수이름이 다를 때 사용
    List<User> 유저명검색(@Param("keyword") String keyword); -> sql과 자바가 사용하는 변수이름 똑같은데 왜 쓰지?

    (@Param("keyword") String keyword) 처럼 SQL에서 받는 변수이름과 java에서 사용하는 변수 이름이 같을 떄는 안써도 된다.

    자바에서는 email이라고 썻는데
    int 이메일중복체크(@Param("naver_email") String email)

    SQL에서는 naver_email로 사용할 경우
    SELECT * FROM users WHERE email = #{naver_emial}
     */

}

