package com.packt.webstore.service;

import com.packt.webstore.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(String productID);
    List<Product> getProductsByCategotry(String category);
    Set<Product> getProductsByFilter(Map<String,List<String>> filterParams);
    List<Product>getProductsManufactured(String manufacturer);
    Set<Product> getProductsByPriceFilter(Map<String,List<String>> paramFilters);
    Set<Product> getProductsByCategoryAndFilter(String category, String manufacturer, Map<String,List<String>> paramFilters);
    void addProduct(Product product);
}
