package com.bridgelabz.addressbook.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class ResponseDTO {
    private String message;
    private Object data;
    private String token;

    public ResponseDTO(String message, Object data , String token) {
        this.message = message;
        this.data = data;
        this.token =token;
    }

    public ResponseDTO(String message) {
        this.message = message;
    }

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
