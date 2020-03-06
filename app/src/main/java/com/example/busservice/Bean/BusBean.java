package com.example.busservice.Bean;

public class BusBean {

    private String bus_id;
    private String bus_name;
    private String 	bus_detail;
    private String 	images;
    private String	price;

    public BusBean(String string, String String) {
    }



    public BusBean(String bus_id, String bus_name, String bus_detail, String images, String price) {
        this.bus_id = bus_id;
        this.bus_name = bus_name;
        this.bus_detail = bus_detail;
        this.images = images;
        this.price = price;
    }

    public String getBus_id() {
        return bus_id;
    }

    public void setBus_id(String bus_id) {
        this.bus_id = bus_id;
    }

    public String getBus_detail() {
        return bus_detail;
    }

    public void setBus_detail(String bus_detail) {
        this.bus_detail = bus_detail;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getbus_name() {
        return bus_name;
    }

    public void setbus_name(String bus_name) {
        this.bus_name = bus_name;
    }


}
