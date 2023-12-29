package com.mysite.Customer.model;

public class RealClient extends Client{
    private String family;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    private String ID;
    public RealClient(String name, String number) {
        super(name, number, ClientType.REAL);
    }

    @Override
    public String toString() {
        return "RealClient{" +
                super.toString()+
                ", family='" + family + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
