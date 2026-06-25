package nst.assaf.assafbackend.service.impl;

import java.util.List;
import nst.assaf.assafbackend.dto.CategoryDto;
import nst.assaf.assafbackend.mapper.CategoryMapper;
import nst.assaf.assafbackend.repository.CategoryRepository;
import nst.assaf.assafbackend.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).toList();
    }
}
