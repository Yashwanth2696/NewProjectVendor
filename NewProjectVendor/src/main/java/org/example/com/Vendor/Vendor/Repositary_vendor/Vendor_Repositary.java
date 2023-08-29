package org.example.com.Vendor.Vendor.Repositary_vendor;


import com.Vendor.Vendor.CreatingDetails.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface Vendor_Repositary extends JpaRepository<Vendor, Integer> {
    Optional<Vendor> findByName(String name);
    Optional<Vendor> findByEmail(String email);
    List<Vendor> findByEmailOrPhoneNumber(String email, long phoneNumber);
    void deleteByEmail(Optional<Vendor> response);
}
