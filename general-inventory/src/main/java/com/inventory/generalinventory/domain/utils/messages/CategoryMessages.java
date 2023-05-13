package com.inventory.generalinventory.domain.utils.messages;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CategoryMessages {

    @Value("${category.controller.created}")
    private String successAdd;
    @Value("${category.controller.getall}")
    private String successGetAll;
    @Value("${category.controller.update}")
    private String successUpdate;
    @Value("${category.controller.delete}")
    private String successDelete;

}
