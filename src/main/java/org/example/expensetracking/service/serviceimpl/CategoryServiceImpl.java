package org.example.expensetracking.service.serviceimpl;

import org.example.expensetracking.model.Category;
import org.example.expensetracking.model.dto.response.CategoryResponse;
import org.example.expensetracking.repository.CategoryRepository;
import org.example.expensetracking.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryResponse> getAllCategories(UUID userId, Integer page, Integer size) {
        List<Category> categoryList = categoryRepository.getAllCategories(userId,page,size);
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for(Category category : categoryList){
            CategoryResponse categoryResponse = modelMapper.map(category, CategoryResponse.class);
            categoryResponses.add(categoryResponse);
        }
        return categoryResponses;
    }

    @Override
    public CategoryResponse getCategoryById(UUID userId, UUID categoryId) {
        Category category = categoryRepository.getCategoryById(categoryId, userId);
        if (category != null) {
            return modelMapper.map(category, CategoryResponse.class);
        } else {

            return null;
        }
    }

    @Override
    public void deleteCategoryById(UUID userId, UUID categoryId) {
        Category category = categoryRepository.getCategoryById(categoryId, userId);
        if (category != null) {
            categoryRepository.deleteCategoryById(categoryId, userId);
        }
    }
}
