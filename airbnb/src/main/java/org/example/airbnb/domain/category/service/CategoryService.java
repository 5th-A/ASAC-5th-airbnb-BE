package org.example.airbnb.domain.category.service;

import lombok.RequiredArgsConstructor;
import org.example.airbnb.domain.category.dto.CategoryResponseDto;
import org.example.airbnb.domain.category.entity.Category;
import org.example.airbnb.domain.category.repository.CategoryRepository;
import org.example.airbnb.exception.CategoryException;
import org.example.airbnb.exception.CustomRuntimeException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryResponseDto> findCatgories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories == null){
            throw new CustomRuntimeException(CategoryException.CATEGORY_NOT_FOUND_EXCEPTION);
        }

        List<CategoryResponseDto> categoryResponseDtosList = categories
                .stream() // 데이터 처리?
                .map(CategoryResponseDto::of) // 객체로 변환
                .collect(Collectors.toList());
        return categoryResponseDtosList;
    }
}
