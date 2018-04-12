package com.packt.webstore.service.imp;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProductById(String productID) {
        return productRepository.getProductById(productID);
    }

    @Override
    public List<Product> getProductsByCategotry(String category) {
        return productRepository.getProductsByCategory(category);
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    @Override
    public List<Product> getProductsManufactured(String manufacturer) {
        return productRepository.getProductsByManufacturer(manufacturer);
    }

    @Override
    public Set<Product> getProductsByPriceFilter(Map<String, List<String>> paramFilters) {
        return productRepository.getProductsByPriceFilter(paramFilters);
    }

    @Override
    public Set<Product> getProductsByCategoryAndFilter(String category, String manufacturer, Map<String, List<String>> paramFilters) {
        List<Product> productsByCategory = productRepository.getProductsByCategory(category);
        List<Product> productsByCategoryAndManufactuer = productRepository.getProductsByManufacturer(manufacturer,productsByCategory);
        Set<Product> productsByPriceFilter = productRepository.getProductsByPriceFilter(paramFilters,productsByCategoryAndManufactuer);
        return productsByPriceFilter;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
