package org.example.com.Vendor.Vendor.CreatingDetails;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity()
@Data
@Validated
@Table(name = "Vendor_user")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private long phoneNumber;
    private String last_name;
    private String log_in;
    private String password;
    private int cart;
    private String buy;
    private int quantity;
    @OneToMany
    private List<Product> product;

}
