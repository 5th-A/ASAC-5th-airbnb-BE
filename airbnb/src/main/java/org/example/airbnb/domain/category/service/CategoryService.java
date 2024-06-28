package org.example.airbnb.domain.category.service;

import lombok.RequiredArgsConstructor;
import org.example.airbnb.domain.category.dto.CategoryResponseDto;
import org.example.airbnb.domain.category.entity.Category;
import org.example.airbnb.domain.category.repository.CategoryRepository;
import org.example.airbnb.domain.room.entity.Room;
import org.example.airbnb.exception.CategoryException;
import org.example.airbnb.exception.CustomRuntimeException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryResponseDto getCategoryByRoom(Room room) {
        Category category = categoryRepository.findById(room.getCategory().getId()) // room에 해당하는 category id 가져옴
                .orElseThrow(()->new CustomRuntimeException(CategoryException.CATEGORY_NOT_FOUND_EXCEPTION));
        CategoryResponseDto categoryResponseDto = CategoryResponseDto.of(category); // entity -> dto
        return categoryResponseDto; // dto를 반환
    }
}
