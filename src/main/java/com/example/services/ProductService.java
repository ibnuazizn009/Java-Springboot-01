package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.entities.Product;
import com.example.models.repositry.ProductRepositroy;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepositroy repositroy;

    public Product saveProduct(Product product){
        return repositroy.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repositroy.saveAll(products);
    }

    public List<Product> getProducts(){
        return repositroy.findAll();
    }

    public Product getProductById(int id){
        return repositroy.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return repositroy.findByName(name).orElse(null);
    }

    public String deleteProduct(int id){
        repositroy.deleteById(id);
        return "Product Removed || "+id;
    }

    public Product updateProduct(Product product){
        Product existingProduct = repositroy.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repositroy.save(existingProduct);
    }

}
