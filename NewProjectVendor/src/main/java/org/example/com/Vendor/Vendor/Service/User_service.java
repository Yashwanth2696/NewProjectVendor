package com.Vendor.Vendor.Service;

import com.Vendor.Vendor.CreatingDetails.User;
import com.Vendor.Vendor.CreatingDetails.Vendor;
import com.Vendor.Vendor.Repositary_vendor.User_repositary;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_service {
        @Autowired
        User_repositary userRepositary;
    public String saveUser(User user) {
        userRepositary.save(user);
        return "done";
    }
    public User fetchVendorDetails(String log_in) {
        var response=userRepositary.findByName(log_in);
        return response.orElse(null);
    }
    public List<User> fetchEmailOrphoneNumber(String email, long phoneNumber) {
        var response=userRepositary.findByEmailOrPhoneNumber(email,phoneNumber);
        if(response.isEmpty()){
            return null;
        }
        else {
            return response;
        }
    }

    public String updatebyEmail(User user, String email) {
        var response = userRepositary.findByEmail(email);
        if (response.isEmpty()) {
            return "not present" + " " + email;
        }
        else {
            if (StringUtils.isNotBlank(user.getName())) {
                response.get().setName(user.getName());
            }
            if(StringUtils.isNotBlank(user.getEmail())){
                response.get().setEmail(user.getEmail());
            }
            if(StringUtils.isNotBlank(user.getLog_in())){
                response.get().getLog_in();
            }
            if(StringUtils.isNotBlank(user.getPassword())){
                response.get().setPassword(user.getPassword());
            }
            if(!response.isEmpty()){
                response.get().setPhoneNumber(user.getPhoneNumber());
            }
            if(StringUtils.isNotBlank(user.getLast_name())){
                response.get().setLast_name(user.getLast_name());
            }
            return "updated!!!";
        }
    }


    public String userDeletbyEmail(String email) {
        var response = userRepositary.findByEmail(email);
        if(response.isEmpty()){
            return "enter email ="+email+" is not present";
        }
        else {
            userRepositary.deleteByEmail(response);
            return "deleted!!!";
        }
    }
}
