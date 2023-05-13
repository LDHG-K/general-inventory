package com.inventory.generalinventory.infraestructure.controllers;

import com.inventory.generalinventory.domain.gateways.ICategoryService;
import com.inventory.generalinventory.domain.models.Category;
import com.inventory.generalinventory.domain.models.dto.Response;
import com.inventory.generalinventory.domain.utils.messages.CategoryMessages;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;
    private final CategoryMessages messages;

    @GetMapping("/all")
    public ResponseEntity<Response> getAllCategories() {

        Response response = new Response();

        try {
            response.setData(categoryService.getAllCategories());
            response.setMessage(messages.getSuccessGetAll());
            response.setHttpStatus("OK");
            response.setDate(LocalDateTime.now().toString());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setData(null);
            response.setMessage(e.getMessage());
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setDate(LocalDateTime.now().toString());
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public ResponseEntity<Response> addCategory(@RequestBody Category category) {

        Response response = new Response();

        try {
            response.setData(categoryService.addCategory(category));
            response.setMessage(messages.getSuccessAdd());
            response.setHttpStatus("OK");
            response.setDate(LocalDateTime.now().toString());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setData(null);
            response.setMessage(e.getMessage());
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setDate(LocalDateTime.now().toString());
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateCategory(@RequestBody Category category) {

        Response response = new Response();

        try {
            response.setData(categoryService.updateCategory(category));
            response.setMessage(messages.getSuccessUpdate());
            response.setHttpStatus("OK");
            response.setDate(LocalDateTime.now().toString());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setData(null);
            response.setMessage(e.getMessage());
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setDate(LocalDateTime.now().toString());
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCategory(@PathVariable("id") Long id) {

        Response response = new Response();

        try {
            response.setData(categoryService.deleteCategory(id));
            response.setMessage(messages.getSuccessDelete());
            response.setHttpStatus("OK");
            response.setDate(LocalDateTime.now().toString());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setData(null);
            response.setMessage(e.getMessage());
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setDate(LocalDateTime.now().toString());
        }
        return ResponseEntity.ok(response);
    }
}
