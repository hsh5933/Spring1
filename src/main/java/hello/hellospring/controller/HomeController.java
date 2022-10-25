package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")  //슬래시 표시는 기본홈화면 표시
    public String home(){
        return "home";  //home.html호출
    }
}
