package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.model.PackageEnwrap;
import com.oocl.packagebooking.service.PackageBookingService;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package-bookings")
public class PackingBookingController {

    @Autowired
    PackageBookingService packageBookingService;

    @GetMapping
    public List<PackageEnwrap> listAllPackageEnwrap(@RequestParam(required = false) Integer filterType){
        if(filterType == null)
            return packageBookingService.findAllPackageEnwrap();
        return packageBookingService.findPackageEnwrapByStatus(filterType);
    }

    @PostMapping
    public PackageEnwrap addPackingEnwrap(@RequestBody PackageEnwrap packageEnwrap){
        return packageBookingService.savePackingEnwrap(packageEnwrap);
    }

}
