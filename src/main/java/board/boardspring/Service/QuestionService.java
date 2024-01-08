package board.boardspring.Service;

import board.boardspring.DataNotFoundException;
import board.boardspring.Domain.Question;
import board.boardspring.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor //생성자 방식 주입
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll(); //db에 있는 모든 Question 엔티티를 가져옴
    }

    public Question getQuestion(Integer id){
        Optional<Question> oq = this.questionRepository.findById(id);
        if(oq.isPresent()){
           return oq.get();
        }
        else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String subject, String content){
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
    public void deleteById(Integer id) {
        this.questionRepository.deleteById(id);
    }

    public Page<Question> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts)); //한페이지에 보여줄 게시물 개수
        return this.questionRepository.findAll(pageable);
    }
}
