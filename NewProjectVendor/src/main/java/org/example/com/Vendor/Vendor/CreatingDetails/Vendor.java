package com.Vendor.Vendor.CreatingDetails;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity()
@Data
@Validated
@Table(name = "Vendor_list")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    private String last_name;
    private String email;
    private  long phoneNumber;
    private String login;
    private String password;

}
