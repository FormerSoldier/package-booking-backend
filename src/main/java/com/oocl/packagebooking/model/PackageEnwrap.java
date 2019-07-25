package com.oocl.packagebooking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class PackageEnwrap {


    @Id
    private Long orderId;
    private String recipientsName;
    @Length(min = 11, max = 11)
    private String telPhone;

    private int orderStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String appointmentTime;

    public PackageEnwrap() {
    }

    public PackageEnwrap(Long orderId, String recipientsName, @Length(min = 11, max = 11) String telPhone) {
        this.orderId =orderId;
        this.recipientsName = recipientsName;
        this.telPhone = telPhone;
        this.appointmentTime = Calendar.getInstance().getTime().toString();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getRecipientsName() {
        return recipientsName;
    }

    public void setRecipientsName(String recipientsName) {
        this.recipientsName = recipientsName;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

}
