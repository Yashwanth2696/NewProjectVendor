package org.example.com.Vendor.Vendor.Service;


import com.Vendor.Vendor.CreatingDetails.Product;
import com.Vendor.Vendor.Repositary_vendor.Product_repositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Product_service {
    @Autowired
    Product_repositary productRepositary;

    public String saveProduct(Product product) {
        System.out.println(product);
        productRepositary.save(product);
        return "saved";
    }

    public Object fetchVendorDetails(String product_name) {
        var response=productRepositary.findByName(product_name);
        return response.orElse(null);
    }

    public String productDeletbyEmail(String name) {
        var response = productRepositary.findByName(name);
        if(response.isEmpty()){
            return "enter name ="+name+" is not present";
        }
        else {
            productRepositary.deleteByName(response);
            return "deleted!!!";
        }
    }
}
