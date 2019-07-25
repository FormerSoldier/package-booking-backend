package com.oocl.packagebooking.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class PackageEnwrap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private String recipientsName;
    @Length(min = 11, max = 11)
    private String telPhone;

    private int orderStatus;
    private String appointmentTime;

    public PackageEnwrap() {
    }

    public PackageEnwrap(String recipientsName, @Length(min = 11, max = 11) String telPhone) {
        this.recipientsName = recipientsName;
        this.telPhone = telPhone;
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
