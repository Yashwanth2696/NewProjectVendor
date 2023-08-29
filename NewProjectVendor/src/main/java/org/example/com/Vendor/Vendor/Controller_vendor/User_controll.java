package org.example.com.Vendor.Vendor.Controller_vendor;

import com.Vendor.Vendor.CreatingDetails.User;
import com.Vendor.Vendor.Service.User_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v3")
public class User_controll {
    @Autowired
    User_service service;
    @PostMapping(value = "/vpnsample", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>savedetais(@RequestBody User user){
        return new ResponseEntity<>(service.saveUser(user), HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/vendors/{log_in}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>fetchVendor(@PathVariable String log_in){
        return new ResponseEntity<>(service.fetchVendorDetails(log_in),HttpStatus.OK);
    }
    @GetMapping(value="/emailOrphoneUser/{email}/{phoneNumber}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>fetchEmailOrPhone(@PathVariable String email,@PathVariable long phoneNumber){
        return new ResponseEntity<>(service.fetchEmailOrphoneNumber(email,phoneNumber),HttpStatus.OK);
    }
    @PutMapping(value = "/update/{email}",produces =MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>updateEmail(@PathVariable String email,@RequestBody User user){
        return new ResponseEntity<>(service.updatebyEmail(user,email),HttpStatus.OK);
    }
    @DeleteMapping(value = "/users/{email}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>deletById(@PathVariable String email ){
        return new ResponseEntity<>(service.userDeletbyEmail(email),HttpStatus.OK);
    }
}
