package com.oocl.packagebooking.service;

import com.oocl.packagebooking.model.PackageEnwrap;
import com.oocl.packagebooking.repository.PackageBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageBookingService {
    @Autowired
    PackageBookingRepository packingBookingRepository;

    public List<PackageEnwrap> findAllPackageEnwrap() {
        return packingBookingRepository.findAll();
    }

    public List<PackageEnwrap> findPackageEnwrapByStatus(int status){
        return packingBookingRepository.findPackageEnwrapByStatus(status);
    }

    public PackageEnwrap savePackingEnwrap(PackageEnwrap packingEnwrap) {
        return packingBookingRepository.save(packingEnwrap);
    }

    public int updatePackageEnwrapStatusByOrderId(Long orderId, int status) {
        return packingBookingRepository.updatePackageEnwrapStatusByOrderId(orderId,status);
    }
}
