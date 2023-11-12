package by.academypvt.errors;

import by.academypvt.dto.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class Handler {
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ErrorResponse notValidated(MethodArgumentNotValidException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getAllErrors().get(0).getDefaultMessage());
        errorResponse.setStatus(400);
        log.error("Exception", e);
        return errorResponse;
    }
}
