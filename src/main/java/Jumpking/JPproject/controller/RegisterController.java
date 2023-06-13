package Jumpking.JPproject.controller;

import Jumpking.JPproject.DTO.UserDTO;
import Jumpking.JPproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;
    @GetMapping("/register")
    public String usersaveForm(){
        return"register";
    }

    @PostMapping("/register")
    public String save(@ModelAttribute UserDTO userDTO){
        System.out.println("RegisterController.save");
        System.out.println("userDTO=" + userDTO);
//        UserService userService = new UserService();
        userService.save(userDTO);
        return "mainpage";
    }

    @GetMapping("/user/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/user/login")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session){
        UserDTO loginResult = userService.login(userDTO);
        if (loginResult !=null){
            //login 성공시
            session.setAttribute("loginid", loginResult.getId());
            return "mainpage";
        } else{
            //login 실패
            return "login";
        }
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "mainpage";
    }

}
