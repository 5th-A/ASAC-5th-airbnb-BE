package org.example.airbnb.domain.category.controller;

import lombok.AllArgsConstructor;
import org.example.airbnb.domain.category.dto.CategoryResponseDto;
import org.example.airbnb.domain.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponseDto>> getCategoryList(){
        List<CategoryResponseDto> catgories = categoryService.findCatgories();
        return ResponseEntity.status(HttpStatus.OK).body(catgories);
    }
}
