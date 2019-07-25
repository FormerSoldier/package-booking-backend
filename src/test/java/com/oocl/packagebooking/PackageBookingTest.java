package com.oocl.packagebooking;


import com.oocl.packagebooking.model.PackageEnwrap;
import com.oocl.packagebooking.service.PackageBookingService;
import com.oocl.packagebooking.util.Constant;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.CannotLoadBeanClassException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PackageBookingTest {
    @Autowired
    PackageBookingService packageBookingService;

    @Test
    public void should_return_packing_enwrap_when_call_save_packing_enwrap_given_packing_enwrap(){
        PackageEnwrap packingEnwrap = new PackageEnwrap(Long.valueOf(2),"李亚娥","18912345678");
        PackageEnwrap result_packingEnwrap = packageBookingService.savePackingEnwrap(packingEnwrap);

        Assertions.assertNotEquals(result_packingEnwrap.getOrderId(),Long.valueOf(0));
    }

    @Test
    public void should_return_package_enwrap_when_call_find_All_packages(){
        PackageEnwrap packingEnwrap = new PackageEnwrap(Long.valueOf(3),"李亚娥","18912345678");
        packageBookingService.savePackingEnwrap(packingEnwrap);

        List<PackageEnwrap> packageEnwrapList = packageBookingService.findAllPackageEnwrap();

        Assertions.assertEquals(packageEnwrapList.size(),1);
    }

    @Test
    public void should_return_packing_enwrap_when_call_find_package_enwrap_by_status_given_status(){
        PackageEnwrap packingEnwrap = new PackageEnwrap(Long.valueOf(4),"李亚娥","18912345678");
        packageBookingService.savePackingEnwrap(packingEnwrap);

        List<PackageEnwrap> packageEnwrapList = packageBookingService.findPackageEnwrapByStatus(Constant.UNPICKED);

        Assertions.assertEquals(packageEnwrapList.size(),1);
    }

    @Test
    public void should_return_affect_rows_count_when_call_update_package_enwrap_status_given_order_id_and_status(){
        PackageEnwrap packingEnwrap = new PackageEnwrap(Long.valueOf(5),"李亚娥","18912345678");
        PackageEnwrap result_packingEnwrap = packageBookingService.savePackingEnwrap(packingEnwrap);

        int rows = packageBookingService.updatePackageEnwrapStatusByOrderId(packingEnwrap.getOrderId(),1);

        Assertions.assertEquals(rows,1);
    }

    @Test
    public void should_return_true_when_call_check_is_in_work_time_given_now(){
        boolean result = packageBookingService.checkIsInWorkTime("2019-07-25 13:22:00");

        Assertions.assertEquals(result,true);
    }

    @Test
    public void should_return_false_when_call_check_is_in_work_time_given_the_data_of_hours_is_ten_pm(){
        boolean result = packageBookingService.checkIsInWorkTime("2019-07-25 22:22:00");

        Assertions.assertEquals(result,false);
    }

    @Test
    public void should_return_package_enwrap_when_call_update_package_enwrap_appointmentTime(){
        PackageEnwrap packingEnwrap = new PackageEnwrap(Long.valueOf(6),"李亚娥","18912345678");
        packingEnwrap = packageBookingService.savePackingEnwrap(packingEnwrap);

        String dateTime ="2019-7-25 3:24";
        packingEnwrap.setAppointmentTime(dateTime);
        packageBookingService.updatePackageEnwrapAppointmentTime(packingEnwrap);

        packingEnwrap = packageBookingService.findPackageEnwrapById(packingEnwrap.getOrderId());

        Assertions.assertEquals(packingEnwrap.getAppointmentTime(),dateTime);

    }

}
