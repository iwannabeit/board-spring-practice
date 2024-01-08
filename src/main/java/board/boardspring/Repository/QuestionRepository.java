package board.boardspring.Repository;

import board.boardspring.Domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String Content); //2개의 열 조회
    List<Question> findBySubjectLike(String subject);
}
