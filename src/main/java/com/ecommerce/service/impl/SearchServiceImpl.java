package com.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.model.Product;
import com.ecommerce.service.SearchService;

@Service
public class SearchServiceImpl extends BaseService implements SearchService {

    @Override
    public List<ProductDTO> get() {
        return null;
    }

    @Override
    public List<ProductDTO> search(String name, Integer minPrice, Integer maxPrice) {
        List<Product> list = productDAO.findByConditions(name, minPrice, maxPrice);
        List<ProductDTO> productDTOList = list.stream().map(this::mapToProductDTO).toList();
        return productDTOList;
    }

    private ProductDTO mapToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    @Override
    public ProductDTO get(Long id) {
        return null;
    }

    @Override
    public void save(ProductDTO e) {
    }

    @Override
    public void update(ProductDTO e) {
    }

    @Override
    public void delete(ProductDTO e) {
    }

}
