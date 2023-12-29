package com.mysite.Customer.service;
import com.mysite.Customer.model.Client;
import com.mysite.Customer.model.LegalClient;
import com.mysite.Customer.model.RealClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientSystem implements AutoCloseable{
    private ArrayList<Client>clients = new ArrayList<>();
    private Scanner scanner =new Scanner(System.in);
    public void run(){
        int choice ;
        do {
            printMenu();
            System.out.print("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    System.out.println("Exit!");
                    break;
                case 1:
                    addClient(scanner);
                    break;
                case 2:
                    printAllClient();
                    break;
                case 3:
                    searchClientByName();
                case 4:
                    editClientByName();
                default:
                    System.out.println("invalid Number!");
            }
        }while (choice!=0);
    }
    private void printMenu() {
        System.out.println("Menu:");
        System.out.println("0.Exit");
        System.out.println("1.Add Client");
        System.out.println("2.Print All Client");
        System.out.println("3.Search Client");
        System.out.println("4.Edit Client");
    }
    private void printAllClient() {
        if (clients.isEmpty()) {
            System.out.println("Phonebook is empty");
        } else {
            System.out.println("All Contact:");
            for (Client client : clients) {
                System.out.println(client.toString());
            }
        }
    }
    private void addClient(Scanner scanner) {
        System.out.println("Client Type:");
        System.out.println("1.Real");
        System.out.println("2.Legal");
        System.out.print("Enter your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1){
            String name = getUserInput("Enter name: ");
            String family = getUserInput("Enter family: ");
            String number = getUserInput("Enter number: ");
            String IdNumber = getUserInput("Enter IDNumber");
            RealClient realClient = new RealClient(name,number);
            realClient.setFamily(family);
            realClient.setID(IdNumber);
            clients.add(realClient);
            System.out.println("Client added successfully!");
        }else {
            String name = getUserInput("Enter name: " );
            String number = getUserInput("Enter number: ");
            String fax = getUserInput("Enter fax: ");
            String Address = getUserInput("Enter Address:");
            LegalClient legalClient = new LegalClient(name,number);
            legalClient.setFax(fax);
            legalClient.setAddress(Address);
            clients.add(legalClient);
            System.out.println("Client added successfully!");
        }

    }
    private void searchClientByName(){
        String name = getUserInput("Enter the name");
        for (Client client : clients){
            if (client.getName().equalsIgnoreCase(name)){
                System.out.println(client);
            }
        }
    }
    private void editClientByName(){
        String name = getUserInput("Enter the Name");
        for (Client client : clients){
            if (client.getName().equalsIgnoreCase(name)){
                System.out.println(client);
                String number = getUserInput("Enter new number:");
                client.setNumber(number);
                if (client instanceof RealClient realClient){
                    String IDNumber = getUserInput("Enter new Id:");
                    realClient.setID(IDNumber);
                } else if (client instanceof LegalClient legalClient) {
                    String fax = getUserInput("Enter fax number:");
                    legalClient.setFax(fax);
                    String Address = getUserInput("Enter new Address:");
                    legalClient.setAddress(Address);
                }
            }
        }
    }
    private void deleteClientByName(){
        String name = getUserInput("Enter the name");
        List<Client> clientToDelete = new ArrayList<>();
        for (Client client : clients){
            if (client.getName().equalsIgnoreCase(name)){
                clientToDelete.add(client);
            }
        }
        if (!clientToDelete.isEmpty()){
            clients.removeAll(clientToDelete);
        }
    }
    private String getUserInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public void close(){
        scanner.close();
    }
}
