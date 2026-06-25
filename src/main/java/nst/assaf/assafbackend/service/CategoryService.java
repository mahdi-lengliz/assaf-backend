package nst.assaf.assafbackend.service;

import java.util.List;
import nst.assaf.assafbackend.dto.CategoryDto;

public interface CategoryService {
    List<CategoryDto> findAll();
}
