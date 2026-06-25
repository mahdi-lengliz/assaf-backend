package nst.assaf.assafbackend.service;

import java.util.List;
import nst.assaf.assafbackend.dto.ProductDto;
import nst.assaf.assafbackend.dto.ProductRequest;

public interface ProductService {
    List<ProductDto> findAll();

    ProductDto findById(Long id);

    ProductDto create(ProductRequest request);

    ProductDto update(Long id, ProductRequest request);

    void delete(Long id);
}
