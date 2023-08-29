package com.Vendor.Vendor.Service;
import com.Vendor.Vendor.CreatingDetails.Vendor;
import com.Vendor.Vendor.Repositary_vendor.Vendor_Repositary;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Vendor_service {
    @Autowired
    Vendor_Repositary vendorRepositary;

    public String saveEmployee(Vendor empObj) {
        vendorRepositary.save(empObj);
        return "saved";
    }

    public Vendor fetchVendorDetails(String name) {
        var response = vendorRepositary.findByName(name);
        return response.orElse(null);
    }


    public List<Vendor> fetchEmailOrphoneNumber(String email, long phoneNumber) {
        var response = vendorRepositary.findByEmailOrPhoneNumber(email,phoneNumber);
        if (response.isEmpty()) {
            return null;
        } else {
            return response;
        }
    }
    public String fetchUpdateByEmail(Vendor vendor, String email) {
        var response = vendorRepositary.findByEmail(email);
        if (response.isEmpty()) {
            return "not present" + " " + email;
        } else {
            if (StringUtils.isNotBlank(vendor.getName())) {
                response.get().setName(vendor.getName());
            }
            if (StringUtils.isNotBlank(vendor.getEmail())) {
                response.get().setEmail(vendor.getEmail());
            }
            if (StringUtils.isNotBlank(vendor.getPassword())) {
                response.get().setPassword(vendor.getPassword());
            }
            if (StringUtils.isNotBlank(vendor.getLogin())) {
                response.get().getLogin();
            }
            if (!response.isEmpty()) {
                response.get().setPhoneNumber(vendor.getPhoneNumber());
            }
            return "yes updated";
        }
    }

    public String studentDeletById(String email) {
        var response = vendorRepositary.findByEmail(email);
        if(response.isEmpty()){
            return "enter email ="+email+" is not present";
        }
        else {
            vendorRepositary.deleteByEmail(response);
            return "deleted!!!";
        }
    }
}