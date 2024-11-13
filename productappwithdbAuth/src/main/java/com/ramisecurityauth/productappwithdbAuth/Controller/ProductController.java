package com.ramisecurityauth.productappwithdbAuth.Controller;

import com.ramisecurityauth.productappwithdbAuth.dto.Voucher;
import com.ramisecurityauth.productappwithdbAuth.model.Product;
import com.ramisecurityauth.productappwithdbAuth.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/productapi")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${voucherService.url}")
    private String voucherServiceURL;

    @GetMapping("/products/")
    public List<Product> getProducts(){
        return repository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") long id){
        return repository.findById(id).get();
    }

    @PostMapping("/products/")
    public Product createProduct(@RequestBody Product product){
        Voucher voucher = restTemplate.getForObject(voucherServiceURL + product.getVoucherCode(),Voucher.class);
        assert voucher != null;
        product.setPrice(product.getPrice().subtract(voucher.getDiscount()));
        return repository.save(product);
    }

    @PutMapping("/products/")
    public Product updateProduct(@RequestBody Product product){
        return repository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        repository.deleteById(id);
    }

}
