package service;

import api.Customer;

import java.util.Map;

public class WorkClients implements WorkingClients {

    @Override
    public void printClients(Map<Integer, Customer> mapCustomers) {
        for (Map.Entry<Integer, Customer> client : mapCustomers.entrySet()) {
            System.out.println(client);
        }
    }

    @Override
    public void printWeightClients(Map<Integer, Customer> mapCustomers) {
        for (Map.Entry<Integer, Customer> customerEntry : mapCustomers.entrySet()) {
            System.out.println("ФИО :"+ customerEntry.getValue().getName() + " Вес : " + customerEntry.getValue().getCustomersWeight());
        }
    }
}
