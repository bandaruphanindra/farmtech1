package com.jfsd.service;


import java.util.List;

import com.jfsd.model.Product;

public interface ProductService {
	public List<Product> getAllProducts();
    Product saveProduct(Product product);
    Product getProductById(int id);
    public String deleteproduct(int id);
    Product findById(Long id); 

    void updateProduct(Product product); 
	
}
