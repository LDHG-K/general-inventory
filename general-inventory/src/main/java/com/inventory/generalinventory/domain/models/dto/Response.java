package com.inventory.generalinventory.domain.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class Response {

    private String message;
    private Object data;
    private String HttpStatus;
    private String date;
}
