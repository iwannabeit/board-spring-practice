package board.boardspring.Service;

import board.boardspring.DataNotFoundException;
import board.boardspring.Domain.Question;
import board.boardspring.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
