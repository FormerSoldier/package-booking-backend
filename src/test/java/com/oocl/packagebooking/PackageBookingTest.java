package com.oocl.packagebooking;


import com.oocl.packagebooking.model.PackageEnwrap;
import com.oocl.packagebooking.service.PackageBookingService;
import com.oocl.packagebooking.util.Constant;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PackageBookingTest {
    @Autowired
    PackageBookingService packageBookingService;

    @Test
    public void should_return_packing_enwrap_when_call_save_packing_enwrap_given_packing_enwrap(){
        PackageEnwrap packingEnwrap = new PackageEnwrap("李亚娥","18912345678");
        PackageEnwrap result_packingEnwrap = packageBookingService.savePackingEnwrap(packingEnwrap);

        Assertions.assertNotEquals(result_packingEnwrap.getOrderId(),Long.valueOf(0));
    }

    @Test
    public void should_return_package_enwrap_when_call_find_All_packages(){
        PackageEnwrap packingEnwrap = new PackageEnwrap("李亚娥","18912345678");
        packageBookingService.savePackingEnwrap(packingEnwrap);

        List<PackageEnwrap> packageEnwrapList = packageBookingService.findAllPackageEnwrap();

        Assertions.assertEquals(packageEnwrapList.size(),1);
    }

    @Test
    public void should_return_packing_enwrap_when_call_find_package_enwrap_by_status_given_status(){
        PackageEnwrap packingEnwrap = new PackageEnwrap("李亚娥","18912345678");
        packageBookingService.savePackingEnwrap(packingEnwrap);

        List<PackageEnwrap> packageEnwrapList = packageBookingService.findPackageEnwrapByStatus(Constant.UNPICKED);

        Assertions.assertEquals(packageEnwrapList.size(),1);
    }
}
