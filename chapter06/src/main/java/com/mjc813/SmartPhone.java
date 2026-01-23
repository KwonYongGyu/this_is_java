package com.mjc813;

public class SmartPhone {
    String company ;
    String model;
    String operatingSystem; // 운영체제
    String display;    // 화면 인치 6.7,   6.1
    String weight; // 25+ 190g, 14Pro 206g
    String batterySize; // 4900mAh, 3200mAh
    String usb; //Type-C, Lightning(USB2.0)

    SmartPhone(String company, String model, String operatingSystem,
               String display, String weight, String batterySize, String usb){
        this.company = company;
        this.model = model;
        this.operatingSystem = operatingSystem;
        this.display = display;
        this.weight = weight;
        this.batterySize = batterySize;
        this.usb = usb;
    }
}
