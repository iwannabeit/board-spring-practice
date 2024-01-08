package board.boardspring.Controller;

import board.boardspring.Domain.Question;
import board.boardspring.Repository.QuestionRepository;
import board.boardspring.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/question/list")
    public String list(Model model){
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
    }

    @GetMapping("/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/question/create")
    public String questionCreate(){
        return "question_form";
    }

    @PostMapping("/question/create")
    public String questionCreate(@RequestParam(value = "subject") String subject, @RequestParam(value = "content") String content){
        this.questionService.create(subject, content);
        return "redirect:/question/list"; //질문 저장후 질문 목록으로 이동
    }


}
