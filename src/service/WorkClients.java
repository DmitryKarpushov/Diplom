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
    public void printWeightClients(Map<Integer, Double> customersWeight) {
        for (Map.Entry<Integer, Double> weight : customersWeight.entrySet()) {
            System.out.println(weight);
        }
    }
}
