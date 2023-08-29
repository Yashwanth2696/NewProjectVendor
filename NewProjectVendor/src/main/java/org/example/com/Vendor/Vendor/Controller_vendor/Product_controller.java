package org.example.com.Vendor.Vendor.Controller_vendor;


import com.Vendor.Vendor.CreatingDetails.Product;
import com.Vendor.Vendor.Service.Product_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v1")
public class Product_controller {
    @Autowired(required=true)
     Product_service service;
    @PostMapping(value = "/vendors", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>saveProduct(@RequestBody Product product){
        String response=service.saveProduct(product);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/vendors/{product_name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>fetchVendor(@PathVariable String product_name){
        return new ResponseEntity<>(service.fetchVendorDetails(product_name),HttpStatus.OK);
    }
    @DeleteMapping(value = "/products/{email}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>deletById(@PathVariable String name ){
        return new ResponseEntity<>(service.productDeletbyEmail(name),HttpStatus.OK);
    }
}
