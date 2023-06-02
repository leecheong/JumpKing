package Jumpking.JPproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JPController {

    @GetMapping("/") //메인페이지
    public String main (){

        return "mainpage";
    }

    @GetMapping("/dawnload") //다운로드 페이지
    public String dawnload(){

        return "dawnload";
    }

    @GetMapping("/post")
    public String postform(){

        return "post";
    }
}
