package org.example.com.Vendor.Vendor.Repositary_vendor;

import com.Vendor.Vendor.CreatingDetails.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface User_repositary extends JpaRepository<User, Integer> {
    Optional<User> findByName(String log_in);
    List<User> findByEmailOrPhoneNumber(String email, long phoneNumber);
    Optional<User> findByEmail(String email);
    void deleteByEmail(Optional<User> response);
}
