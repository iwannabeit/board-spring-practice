package hello.hellospring.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") //웹에서 /hello 를 치면 이 메소드 호출
    public String hello(Model model){
        model.addAttribute("data", "hello"); //data라는 곳에 넣은 값은 hello -> hello.index의 중괄호 부분에 대응된다.
        return "hello";
    }
}
