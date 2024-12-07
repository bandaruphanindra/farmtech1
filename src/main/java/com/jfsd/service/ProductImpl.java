package com.jfsd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.model.Product;
import com.jfsd.repository.ProductRepository;
@Service
public  class ProductImpl implements ProductService{
	@Autowired
	private ProductRepository  productRepository;
	@Override
	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}
	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}
	@Override
	public Product getProductById(int id) {
		
		 return productRepository.findById((long) id).orElse(null);
	}
	@Override
	public String deleteproduct(int id) {
		
		productRepository.deleteById((long) id);
		return "Product deleted Sucessfully";
		
		
		
	}
	
	  @Override
	    public Product findById(Long id) {
	        Optional<Product> productOptional = productRepository.findById(id);
	        return productOptional.orElse(null); 
	    }

	    @Override
	    public void updateProduct(Product product) {
	        if (product != null && product.getId() != null) {
	          
	            Optional<Product> existingProductOpt = productRepository.findById(product.getId());
	            if (existingProductOpt.isPresent()) {
	                Product existingProduct = existingProductOpt.get();
	                existingProduct.setPrice(product.getPrice());
	                existingProduct.setQuantity(product.getQuantity());
	                existingProduct.setUnit(product.getUnit());
	                productRepository.save(existingProduct); 
	            } else {
	                throw new IllegalArgumentException("Product with ID " + product.getId() + " does not exist.");
	            }
	        } else {
	            throw new IllegalArgumentException("Invalid product details.");
	        }
	    }
	    
	

}
