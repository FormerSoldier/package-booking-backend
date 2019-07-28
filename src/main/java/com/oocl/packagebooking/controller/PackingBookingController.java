package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.model.PackageEnwrap;
import com.oocl.packagebooking.service.PackageBookingService;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/package-bookings")
public class PackingBookingController {

    @Autowired
    PackageBookingService packageBookingService;

    @GetMapping
    public List<PackageEnwrap> listAllPackageEnwrap(@RequestParam(required = true) Integer filterType){
        System.out.println(filterType);
        if(filterType == null || filterType == 1)
            return packageBookingService.findAllPackageEnwrap();
        return packageBookingService.findPackageEnwrapByStatus(filterType);
    }

    @PostMapping
    public PackageEnwrap addPackageEnwrap(@RequestBody PackageEnwrap packageEnwrap){
        System.out.println(packageEnwrap);
        return packageBookingService.savePackingEnwrap(packageEnwrap);
    }

    @PutMapping
    public List<PackageEnwrap> updatePackageEnwrap(@RequestBody PackageEnwrap packageEnwrap){
        System.out.println("update"+packageEnwrap);
       if(packageEnwrap != null && packageEnwrap.getOrderId() != null)
            packageBookingService.updatePackageEnwrapStatusByOrderId(packageEnwrap.getOrderId(), packageEnwrap.getOrderStatus());
        return listAllPackageEnwrap(packageEnwrap.getOrderStatus());
    }

    @PutMapping("/appointment")
    public PackageEnwrap updatePackageEnwrapAppointmentTime(@RequestBody PackageEnwrap packageEnwrap){
        return packageBookingService.updatePackageEnwrapAppointmentTime(packageEnwrap);
    }

}
