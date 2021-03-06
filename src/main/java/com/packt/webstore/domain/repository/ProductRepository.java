package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    List<Product> getProductsByManufacturer(String manufacturer);

    List<Product> getProductsByManufacturer(String manufacturer, List<Product> listOfProductsFilterByCategory);

    Set<Product> getProductsByPriceFilter(Map<String,List<String>> priceFilter);

    Set<Product> getProductsByPriceFilter(Map<String, List<String>> priceFilter, List<Product> ProductsByCategoryAndManufacturer);

    void addProduct(Product product);

}