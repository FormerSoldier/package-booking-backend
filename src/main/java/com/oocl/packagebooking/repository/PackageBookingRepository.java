package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.model.PackageEnwrap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PackageBookingRepository extends JpaRepository<PackageEnwrap, Long> {
    @Query(value= "SELECT * FROM package_enwrap WHERE order_status = :status ",nativeQuery = true)
    public List<PackageEnwrap> findPackageEnwrapByStatus(@Param("status") int status);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE package_enwrap SET order_status = :status WHERE order_id = :id", nativeQuery = true)
    public int updatePackageEnwrapStatusByOrderId(@Param("status") Long status,@Param("id") int id);
}
