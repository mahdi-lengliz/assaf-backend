package nst.assaf.assafbackend.service.impl;

import java.util.List;
import nst.assaf.assafbackend.dto.ProductDto;
import nst.assaf.assafbackend.dto.ProductRequest;
import nst.assaf.assafbackend.exception.BadRequestException;
import nst.assaf.assafbackend.exception.ResourceNotFoundException;
import nst.assaf.assafbackend.mapper.ProductMapper;
import nst.assaf.assafbackend.model.Category;
import nst.assaf.assafbackend.model.Product;
import nst.assaf.assafbackend.repository.CategoryRepository;
import nst.assaf.assafbackend.repository.ProductRepository;
import nst.assaf.assafbackend.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto findById(Long id) {
        return productMapper.toDto(getProduct(id));
    }

    @Override
    public ProductDto create(ProductRequest request) {
        validate(request);
        Product product = new Product();
        productMapper.updateEntity(product, request, getCategory(request.categoryId()));
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductDto update(Long id, ProductRequest request) {
        validate(request);
        Product product = getProduct(id);
        productMapper.updateEntity(product, request, getCategory(request.categoryId()));
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produit introuvable");
        }
        productRepository.deleteById(id);
    }

    private Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produit introuvable"));
    }

    private Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categorie introuvable"));
    }

    private void validate(ProductRequest request) {
        if (request.name() == null || request.name().isBlank()) {
            throw new BadRequestException("Nom du produit requis");
        }
        if (request.price() == null || request.price().signum() <= 0) {
            throw new BadRequestException("Prix invalide");
        }
        if (request.categoryId() == null) {
            throw new BadRequestException("Categorie requise");
        }
    }
}
