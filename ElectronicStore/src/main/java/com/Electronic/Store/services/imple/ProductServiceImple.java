package com.Electronic.Store.services.imple;

import com.Electronic.Store.dtos.Catagorydtos;
import com.Electronic.Store.dtos.Productdtos;
import com.Electronic.Store.entities.Catagory;
import com.Electronic.Store.entities.Product;
import com.Electronic.Store.repositories.CatagoryRepository;
import com.Electronic.Store.repositories.ProductRepository;
import com.Electronic.Store.services.CatagoryService;
import com.Electronic.Store.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImple implements ProductService {
    @Autowired
   private ModelMapper modelMapper;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CatagoryRepository catagoryRepository;
    @Autowired
    private CatagoryServiceImple catagoryServiceImple;

    @Autowired
    CatagoryService catagoryService;
    @Override
    public Productdtos createProduct(Productdtos productdtos) {
        Product product= productdtosToProduct(productdtos);
        productRepository.save(product);
        return productToProductdtos(product);

    }

    @Override
    public Productdtos updateProduct(Productdtos productdtos, String id) {
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        product.setProductId(id);
        product.setDescription(productdtos.getDescription());
        product.setLive(productdtos.isLive());
        product.setPrice(productdtos.getPrice());
        product.setStock(productdtos.isStock());
        product.setQuantity(productdtos.getQuantity());
        product.setTitle(productdtos.getTitle());
        product.setAddedDate(productdtos.getAddedDate());
        product.setDisCountedPrice(productdtos.getDisCountedPrice());
        productRepository.save(product);
        return productToProductdtos(product);
    }

    @Override
    public String deleteProduct(String id) {
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
        productRepository.delete(product);
        return "Delete Successfully";

    }

    @Override
    public Productdtos searchProduct(String id) {
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
        return productToProductdtos(product);
    }

    @Override
    public List<Productdtos> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        List<Productdtos>productdtosList = new ArrayList<>();
        for(Product p : productList){
            productdtosList.add(productToProductdtos(p));
        }
        return productdtosList;
    }

    @Override
    public List<Productdtos> getAllProductLive() {
       List<Product> productList = productRepository.findByLiveTrue();
        List<Productdtos>productdtosList = new ArrayList<>();
        for(Product p : productList){
            productdtosList.add(productToProductdtos(p));
        }
        return productdtosList;
    }

    public List<Productdtos> findByTitle(String title){
        List<Product> byTitleContaining = productRepository.findByTitleContaining(title);
        List<Productdtos>productdtosList = new ArrayList<>();
        for(Product p : byTitleContaining){
            productdtosList.add(productToProductdtos(p));
        }
        return productdtosList;
    }

    @Override
    public Productdtos createProductWithCatagory(Productdtos productdtos, String catagoryId) {
        Catagory catagory = catagoryServiceImple.getCatagory(catagoryId);
        productdtos.setCatagory(catagory);
        Product product = productdtosToProduct(productdtos);
        productRepository.save(product);
        return productToProductdtos(product);

    }

    @Override
    public Productdtos updateProductCatagory(String catagoryId, String productId) {
        Catagory catagory = catagoryService.getCatagory(catagoryId);
        Product product = productRepository.findById(productId).orElseThrow(()->new RuntimeException("Not Found"));
        product.setCatagory(catagory);
        productRepository.save(product);
        return productToProductdtos(product);
    }

    //----------------conversion product to productdtos----------------------
    public Productdtos productToProductdtos(Product product){
        return modelMapper.map(product,Productdtos.class);
    }
    public Product productdtosToProduct(Productdtos productdtos){
        return modelMapper.map(productdtos,Product.class);
    }
}
