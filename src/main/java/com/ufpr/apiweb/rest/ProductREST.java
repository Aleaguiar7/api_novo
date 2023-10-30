package com.ufpr.apiweb.rest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufpr.apiweb.model.Product;

@CrossOrigin
@RestController
public class ProductREST {
    public static List<Product> productList = new ArrayList<>();
    
    @GetMapping("/product")
    public List<Product> getProducts() {
        return productList;
    }
    
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        Product product = productList.stream().filter(prod -> prod.getId() == id).findAny().orElse(null);
        return product;
    }
    
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        Product lastProduct = productList.stream().max(Comparator.comparing(Product::getId)).orElse(null);
        if (lastProduct == null)
            product.setId(1);
        else
            product.setId(lastProduct.getId() + 1);
        productList.add(product);
        return product;
    }
    
    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        Product existingProduct = productList.stream().filter(prod -> prod.getId() == id).findAny().orElse(null);
        if (existingProduct != null) {
            existingProduct.setDescricao(product.getDescricao());
            existingProduct.setValor(product.getValor());
        }
        return existingProduct;
    }
    
    @DeleteMapping("/product/{id}")
    public Product deleteProduct(@PathVariable("id") int id) {
        Product product = productList.stream().filter(prod -> prod.getId() == id).findAny().orElse(null);
        if (product != null)
            productList.removeIf(p -> p.getId() == id);
        return product;
    }

    static {
        productList.add(new Product(1, "Produto A", 2L));
        productList.add(new Product(2, "Produto B", 3L));
        productList.add(new Product(2, "Produto B", 4L));
    }
}
