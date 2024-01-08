package board.boardspring;

import board.boardspring.Domain.Answer;
import board.boardspring.Domain.Question;
import board.boardspring.Repository.AnswerRepository;
import board.boardspring.Repository.QuestionRepository;
import board.boardspring.Service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class BoardSpringApplicationTests {
	@Autowired
	private QuestionService questionService;

	@Test
	void testJPA(){
//		for (int i= 2109; i <= 2409; i++) {
//			questionService.deleteById(i);
//		}
	}

}
