package nst.assaf.assafbackend.mapper;

import nst.assaf.assafbackend.dto.CategoryDto;
import nst.assaf.assafbackend.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDto toDto(Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getEmoji());
    }
}
