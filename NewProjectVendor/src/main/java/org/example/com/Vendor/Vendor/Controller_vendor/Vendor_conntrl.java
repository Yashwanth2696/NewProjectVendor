package com.Vendor.Vendor.Controller_vendor;


import com.Vendor.Vendor.CreatingDetails.Vendor;
import com.Vendor.Vendor.Service.Vendor_service;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@Validated
@RequestMapping("/api/v2")
public class Vendor_conntrl {
    @Autowired
    Vendor_service service;
    @PostMapping(value = "/vendors", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<?> saveEmployeeToDb(@Valid @RequestBody Vendor empObj){
        String response = service.saveEmployee(empObj);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/vendors/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>fetchVendor(@PathVariable String name){
        return new ResponseEntity<>(service.fetchVendorDetails(name),HttpStatus.OK);
    }
    @GetMapping(value="/emailOrphone/{email}/{phoneNumber}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>fetchEmailOrPhone(@PathVariable String email,@PathVariable long phoneNumber){
        return new ResponseEntity<>(service.fetchEmailOrphoneNumber(email,phoneNumber),HttpStatus.OK);
    }
    @PutMapping(value = "/update/{email}",produces =MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>updateEmailOrPhone(@RequestBody Vendor vendor ,@PathVariable String email){
        return new ResponseEntity<>(service.fetchUpdateByEmail(vendor,email),HttpStatus.OK);
    }
    @DeleteMapping(value = "/vendors/delet/{email}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>deletById(@PathVariable String email ){
        return new ResponseEntity<>(service.studentDeletById(email),HttpStatus.OK);
    }
}
