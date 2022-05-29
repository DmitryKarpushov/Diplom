package service;

import api.Customer;
import java.util.Map;

public interface WorkingClients {
    void printClients(Map<Integer, Customer> mapCustomers);
    void printWeightClients(Map<Integer, Double> customersWeight);
}
