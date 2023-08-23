package com.example.app.Controller;

import com.example.app.Model.Product;
import com.example.app.config.Sender;
import com.example.app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class AppController
{
    @Autowired
    AppRepository appRepository;

    @Autowired
    Sender sender;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/sayHello")
    public String sayHello() {
        return "SayHello";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllProducts")
        public List<Product> getAllProducts()
       {
            return appRepository.findAll();
        }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/createProduct/MQSendMessage")
    public Product createProduct(@RequestBody Product product){
        System.out.println("Product creation is happening");
        Product newProduct = new Product();
        newProduct.setProductName(product.getProductName());
        newProduct.setProductCost(product.getProductCost());
        newProduct.setProductCategory(product.getProductCategory());
        newProduct.setProductDescription(product.getProductDescription());
        newProduct.setCreatedTimestamp(product.getCreatedTimestamp());
        Product savedProduct= appRepository.save(newProduct);
       // System.out.println("Saved product data: " + savedProduct);
        //return savedProduct;
        String productMessage = "New product created: " + savedProduct.toString();
        sender.send(productMessage);

        return savedProduct;
    }


   /* @PostMapping("/MQ/sendMessage")
    public String postMessageToMQ(@RequestBody String message)
    {

        System.err.println("Received message: " + message);
        sender.send(message);
        return "Successfully sent message to MQ.";
    }*/


}

