package be.app.Todo.exception;

import be.app.Todo.entity.ErrorExceptionResponse;
import be.app.Todo.service.TextFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class RestExceptionHandler {
    @Autowired
    private TextFileService textFileService;
    @ExceptionHandler
    public ResponseEntity<ErrorExceptionResponse> handleException(NotFoundException ex){
        ErrorExceptionResponse error = new ErrorExceptionResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        textFileService.saveMessage(error.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorExceptionResponse> handleException(Exception ex){
        ErrorExceptionResponse error = new ErrorExceptionResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        textFileService.saveMessage(error.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
