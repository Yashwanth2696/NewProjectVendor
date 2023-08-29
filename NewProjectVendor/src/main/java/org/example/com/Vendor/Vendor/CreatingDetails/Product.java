package com.example.com.Vendor.Vendor.CreatingDetails;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity()
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double product_rate;
    private int product_avilabality;
    private String product_sts;
    @ManyToOne(cascade =CascadeType.ALL )
    private User use;
}
