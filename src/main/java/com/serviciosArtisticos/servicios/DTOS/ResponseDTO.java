package com.serviciosArtisticos.servicios.DTOS;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ResponseDTO<T> {

    private boolean success;
    private int status_code;
    private String message;
    private Object data;

    public ResponseDTO(boolean success, int status_code, String message) {
        this.success = success;
        this.status_code = status_code;
        this.message = message;
    }

    public ResponseDTO(boolean success, int status_code, String message, Object data) {
        this.success = success;
        this.status_code = status_code;
        this.message = message;
        this.data = data;
    }

//    public ResponseDTO(boolean success, ErrorCode errorCode, Object data) {
//        this.success = success;
//        this.status_code = errorCode.getCode();
//        this.message = errorCode.getMessage();
//        this.data = data;
//    }
}
