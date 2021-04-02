package ru.romankuznetsov.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.romankuznetsov.dto.ErrorDto;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorDto> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
