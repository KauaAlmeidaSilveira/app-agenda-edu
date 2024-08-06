package com.agendaedu.schedule_service.controllers.handler;

import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends CustomError {

    private final List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String erro, String path) {
        super(timestamp, status, erro, path);
    }

    public void addError(String fieldName, String message) {
        erros.removeIf(x -> x.getFieldName().equals(fieldName));
        erros.add(new FieldMessage(fieldName, message));
    }
}
