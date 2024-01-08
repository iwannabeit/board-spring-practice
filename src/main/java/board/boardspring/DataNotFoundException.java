package board.boardspring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 데이터를 찾을 수 없으면 entity not found가 나오게끔
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public DataNotFoundException(String msg){
        super(msg);
    }
}
