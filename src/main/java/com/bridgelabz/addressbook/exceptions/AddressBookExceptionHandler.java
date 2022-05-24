package com.bridgelabz.addressbook.exceptions;

import com.bridgelabz.addressbook.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class AddressBookExceptionHandler {
    private static final String message = "Exception while processing REST Request";
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO(message , errMsg);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddressBookException.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(AddressBookException exception){
        ResponseDTO responseDTO = new ResponseDTO(message, exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.BAD_REQUEST);
    }
}
