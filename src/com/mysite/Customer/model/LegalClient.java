package com.mysite.Customer.model;

public class LegalClient extends Client {
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    private String fax;
    private String Address;
    public LegalClient(String name, String number) {
        super(name, number, ClientType.LEGAL);
    }

    @Override
    public String toString() {
        return "LegalClient{" +
                 super.toString()+
                ", fax='" + fax + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
