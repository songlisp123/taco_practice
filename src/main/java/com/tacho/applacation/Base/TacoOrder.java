package com.tacho.applacation.Base;

//import lombok.Data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TacoOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryProvince;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private List<Taco> tacos = new ArrayList<>();
    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

//    public TacoOrder() {
//    }
//
//    public String getDeliveryName() {
//        return deliveryName;
//    }
//
//    public void setDeliveryName(String deliveryName) {
//        this.deliveryName = deliveryName;
//    }
//
//    public String getDeliveryStreet() {
//        return deliveryStreet;
//    }
//
//    public void setDeliveryStreet(String deliveryStreet) {
//        this.deliveryStreet = deliveryStreet;
//    }
//
//    public String getDeliveryCity() {
//        return deliveryCity;
//    }
//
//    public void setDeliveryCity(String deliveryCity) {
//        this.deliveryCity = deliveryCity;
//    }
//
//    public String getDeliveryState() {
//        return deliveryState;
//    }
//
//    public void setDeliveryState(String deliveryState) {
//        this.deliveryState = deliveryState;
//    }
//
//    public String getDeliveryProvince() {
//        return deliveryProvince;
//    }
//
//    public void setDeliveryProvince(String deliveryProvince) {
//        this.deliveryProvince = deliveryProvince;
//    }
//
//    public String getDeliveryZip() {
//        return deliveryZip;
//    }
//
//    public void setDeliveryZip(String deliveryZip) {
//        this.deliveryZip = deliveryZip;
//    }
//
//    public String getCcNumber() {
//        return ccNumber;
//    }
//
//    public void setCcNumber(String ccNumber) {
//        this.ccNumber = ccNumber;
//    }
//
//    public String getCcExpiration() {
//        return ccExpiration;
//    }
//
//    public void setCcExpiration(String ccExpiration) {
//        this.ccExpiration = ccExpiration;
//    }
//
//    public String getCcCVV() {
//        return ccCVV;
//    }
//
//    public void setCcCVV(String ccCVV) {
//        this.ccCVV = ccCVV;
//    }
//
//    public List<Taco> getTacos() {
//        return tacos;
//    }
//
//    public void setTacos(List<Taco> tacos) {
//        this.tacos = tacos;
//    }
//
//    @Override
//    public String toString() {
//        return "TacoOrder{" +
//                "deliveryName='" + deliveryName + '\'' +
//                ", deliveryStreet='" + deliveryStreet + '\'' +
//                ", deliveryCity='" + deliveryCity + '\'' +
//                ", deliveryState='" + deliveryState + '\'' +
//                ", deliveryProvince='" + deliveryProvince + '\'' +
//                ", deliveryZip='" + deliveryZip + '\'' +
//                ", ccNumber='" + ccNumber + '\'' +
//                ", ccExpiration='" + ccExpiration + '\'' +
//                ", ccCVV='" + ccCVV + '\'' +
//                ", tacos=" + tacos +
//                '}';
//    }


}
