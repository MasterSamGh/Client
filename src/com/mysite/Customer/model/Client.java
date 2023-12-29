package com.mysite.Customer.model;

public abstract class Client {
    private String name;
    private String number;
    private final ClientType type;

    public Client(String name, String number, ClientType type) {
        this.name = name;
        this.number = number;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Client:{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", type=" + type +
                '}';
    }

    public ClientType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
