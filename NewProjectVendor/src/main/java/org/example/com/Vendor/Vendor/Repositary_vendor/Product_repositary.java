package org.example.com.Vendor.Vendor.Repositary_vendor;


import com.Vendor.Vendor.CreatingDetails.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Product_repositary extends JpaRepository<Product, Integer> {
    Optional<Product> findByName(String product_name);
    void deleteByName(Optional<Product> response);
}
