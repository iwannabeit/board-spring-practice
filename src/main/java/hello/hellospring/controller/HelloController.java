package hello.hellospring.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") //웹에서 /hello 를 치면 이 메소드 호출
    public String hello(Model model){
        model.addAttribute("data", "hello"); //data라는 곳에 넣은 값은 hello -> hello.index의 중괄호 부분에 대응된다.
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name); //name = spring
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http의 body 부분에 return 값을 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //"hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody //json으로 반환된다.
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }

}
