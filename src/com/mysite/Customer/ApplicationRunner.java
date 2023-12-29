package com.mysite.Customer;

import com.mysite.Customer.service.ClientSystem;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (ClientSystem clientSystem = new ClientSystem()){
            clientSystem.run();
        }
    }
}
