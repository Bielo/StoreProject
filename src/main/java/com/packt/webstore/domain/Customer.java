package com.packt.webstore.domain;

public class Customer {
   private String customerId;
   private String name;
   private String address;
   private String noOfOrdersMade;

    public Customer(String customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(String noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }

    @Override
    public String toString() {
        return "Klient [customer Id=" + customerId + ", imie = " + name + "]";
    }
}
