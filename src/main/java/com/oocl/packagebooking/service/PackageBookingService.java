package com.oocl.packagebooking.service;

import com.oocl.packagebooking.model.PackageEnwrap;
import com.oocl.packagebooking.repository.PackageBookingRepository;
import com.oocl.packagebooking.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageBookingService {
    @Autowired
    PackageBookingRepository packingBookingRepository;

    public PackageEnwrap findPackageEnwrapById(Long id){
        return packingBookingRepository.findById(id).get();
    }

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

    public boolean checkIsInWorkTime(String time){
        int hour = Integer.valueOf(time.split(" ")[1].split(":")[0]);
        return hour > Constant.START_TIME && hour < Constant.END_TIME;
    }

    public PackageEnwrap updatePackageEnwrapAppointmentTime(PackageEnwrap packageEnwrap){
        if(!checkIsInWorkTime(packageEnwrap.getAppointmentTime()))
            return null;
        PackageEnwrap result_packageEnwrap = findPackageEnwrapById(packageEnwrap.getOrderId());
        result_packageEnwrap.setAppointmentTime(packageEnwrap.getAppointmentTime());
        return packingBookingRepository.save(result_packageEnwrap);
    }
}
