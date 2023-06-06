package Jumpking.JPproject.controller;
import Jumpking.JPproject.Entity.post;
import Jumpking.JPproject.service.JPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JPController {

    @Autowired
    private JPService jpService;

    @GetMapping("/") //메인페이지
    public String main (){

        return "mainpage";
    }

    @GetMapping("/dawnload") //다운로드 페이지
    public String dawnload(){

        return "dawnload";
    }

    @GetMapping("/post") //게시글 작성 페이지
    public String postform(){

        return "post";
    }

    @PostMapping("/post/write")
    public String postWrite(post Post) {

        jpService.write(Post);
        System.out.println(Post.getTitle());

        return "postlist";
    }

    @GetMapping("/post/list") //게시글 리스트 페이지
    public String postlist(Model model){

        model.addAttribute("list", jpService.postList());

        return "postlist";
    }
}
