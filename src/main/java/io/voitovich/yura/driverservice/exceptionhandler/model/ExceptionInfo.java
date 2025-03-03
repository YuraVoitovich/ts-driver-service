package io.voitovich.yura.driverservice.exceptionhandler.model;

import lombok.Builder;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

@Builder
public record ExceptionInfo (
    @NonNull
    HttpStatus status,
    @NonNull
    String message

){}
