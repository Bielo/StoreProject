package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.ProductNotFoundException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<Product>();

    public InMemoryProductRepository() {
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym ekranem o rozdzielczości 640x1136 i 8-megapikselowym aparatem");
        iphone.setCategory("SmartPhone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny) z procesorem Intel Core 3. generacji");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product("P1236", "Nexus 7 ", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym tabletem z 4-rdzeniowym procesorem Qualcomm Snapdragon™ S4 Pro");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
    }

    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    @Override
    public Product getProductById(String productId) {
        Product productById = null;
        for (Product product : listOfProducts) {
            if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
                productById = product;
                break;
            }
        }
        if (productById == null) {
            throw new ProductNotFoundException(productId);
        }
        return productById;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product : listOfProducts) {
            if (category.equalsIgnoreCase(product.getCategory())) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
        List<Product> productsByManufacturer = new ArrayList<>();
        for (Product product : listOfProducts) {
            if (manufacturer.equalsIgnoreCase(product.getManufacturer())) {
                productsByManufacturer.add(product);
            }
        }
        return productsByManufacturer;
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer, List<Product> listOfProductsFilterByCategory) {
        List<Product> productsByManufacturer = new ArrayList<>();
        for (Product product : listOfProductsFilterByCategory) {
            if (manufacturer.equalsIgnoreCase(product.getManufacturer())) {
                productsByManufacturer.add(product);
            }
        }
        return productsByManufacturer;
    }


    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<>();
        Set<String> criterias = filterParams.keySet();
        if (criterias.contains("brand")) {
            for (String brandName : filterParams.get("brand")) {
                for (Product product : listOfProducts) {
                    if (brandName.equalsIgnoreCase(product.getManufacturer())) {
                        productsByBrand.add(product);
                    }
                }
            }
        }
        if (criterias.contains("category")) {
            for (String category : filterParams.get("category")) {
                productsByCategory.addAll(this.getProductsByCategory(category));
            }
        }
        productsByCategory.retainAll(productsByBrand);
        return productsByCategory;
    }

    @Override
    public Set<Product> getProductsByPriceFilter(Map<String, List<String>> priceFilter) {

        Set<String> parameters = priceFilter.keySet();

        String lowerPrice = "0";
        String hightestPrice = "0";

        if (parameters.contains("low")) {
            for (String lowPrice : priceFilter.get("low")) {
                lowerPrice = lowPrice;
            }
        }

        if (parameters.contains("hight")) {
            for (String hightPrice : priceFilter.get("hight")) {
                hightestPrice = hightPrice;
            }
        }

        BigDecimal low = new BigDecimal(lowerPrice);
        BigDecimal hight = new BigDecimal(hightestPrice);

        Set<Product> productsFilterByPrice = new HashSet<>();
        for (Product product : listOfProducts) {
            if (product.getUnitPrice().compareTo(low) >= 0 && product.getUnitPrice().compareTo(hight) <= 0) {
                productsFilterByPrice.add(product);
            }
        }
        return productsFilterByPrice;
    }

    @Override
    public Set<Product> getProductsByPriceFilter(Map<String, List<String>> priceFilter, List<Product> productsByCategoryAndManufacturer) {
        Set<String> parameters = priceFilter.keySet();

        Set<Product> productsFilter = new HashSet<>();

        String lowerPrice = "0";
        String hightestPrice = "0";

        if (parameters.contains("low")) {
            for (String lowPrice : priceFilter.get("low")) {
                lowerPrice = lowPrice;
            }
        }

        if (parameters.contains("hight")) {
            for (String hightPrice : priceFilter.get("hight")) {
                hightestPrice = hightPrice;
            }
        }

        BigDecimal low = new BigDecimal(lowerPrice);
        BigDecimal hight = new BigDecimal(hightestPrice);

        for (Product product : productsByCategoryAndManufacturer) {
            if (product.getUnitPrice().compareTo(low) >= 0 && product.getUnitPrice().compareTo(hight) <= 0) {
                productsFilter.add(product);
            }
        }
        return productsFilter;
    }

    @Override
    public void addProduct(Product product) {
        listOfProducts.add(product);
    }
}