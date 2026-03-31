package com.project.instagramclone.controller;

import com.project.instagramclone.model.dto.Location;
import com.project.instagramclone.model.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

/**
 * 확장자 별 파일 명칭
 * 파스칼케이스(시작하는 단어 기준 대문자) : .java
 * 카멜케이스(aBc)                     : .java
 * 스네이크케이스(_) : .jsp or .html
 * 케밥케이스(-)    : .css .js .xml 폴더명 클래스와 아이디, name 명칭 또한 사용
 *
 * 모든 단어를 대문자로 사용 -> 상수 처럼 변하는 데이터가 없을 때만 사용
 *
 * javaScript 내부는 변수 명칭에서 카멜케이스 or 케밥케이스 둘 중 하나로 변수이름을 작성한다.
 */

@Controller
@RequiredArgsConstructor
    public class ViewController {

    private final LocationService locationService;
    /**
     * 보통 "/" 경로는 따로 만들지 않아도
     * @return index.jsp 나 index.html파일을 바라보도록 설정되어 있다.
     * 자동감지설정이 읽혀지지 않을 수 있기 때문에 index 세팅
     */

    @GetMapping("/")
        public String indexView(Model model) {
        return "index";
        }

        @GetMapping("/user/login")
        public String loginView(Model model) {
            return "user/login";
        }

        @GetMapping("/map")
        public String kakaoMapView(Model model) {
            List<Location> 장소목록데이터 = locationService.장소목록가져오기();
            model.addAttribute ("locations", 장소목록데이터);
            return "kakao/kakao-map";
        }

        @GetMapping("/user/register")
        public String detailView() {
            return "user/register";
        }

        @GetMapping("/board/list")
        public String listView(Model model) {
            return "/board/list";
        }

        @GetMapping("/board/detail")
        public String detailView(int board_no, Model model) {
            return "board/detail";
        }

        @GetMapping("/board/write")
        public String writeView() {
            return "board/write";
        }

        @GetMapping("/board/edit")
        public String editView(int board_no, Model model) {
            return "board/edit";
        }

        @GetMapping("/users/list")
        public String allUserView() {
            return "user/user-list";
        }
}
