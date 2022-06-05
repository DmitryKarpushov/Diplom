package database;

import api.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "464890Elena";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Bank";
    private static ResultSet result;
    private static final int DEL = 1000000;
    private int MILLISECOND = 86400000;
    private List<Customer> customers = new ArrayList<>();
    private Map<Integer, Customer> mapCustomers = new HashMap<>();
    private Integer idTask = 0;
   // private Map<Integer, Double> customersWeight = new HashMap<>();

    public void readingBD() throws SQLException {
        customers.clear();
        mapCustomers.clear();
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        System.out.println("Считывание данных:");
        //Объект отправляет запрос в бд
        Statement statement = connection.createStatement();
        String SQL_SELECT_REQUESTSCUSTOMER = "select * from requestscustomer order by id";
        //Объект хранит запрос в бд
        result = statement.executeQuery(SQL_SELECT_REQUESTSCUSTOMER);
        while (result.next()) {
            Date firstDate = result.getDate("dateloanto");
            Date secondDate = result.getDate("dateloanfrom");
            long delt = (secondDate.getTime() - firstDate.getTime()) / MILLISECOND;
            //double weightClient = (result.getDouble("rate") * delt * result.getInt("qualitycategory")
            //      * result.getInt("loanamount"))/DEL;
            double weightClient = (delt * result.getInt("loanamount"))/DEL;
            //customersWeight.put(result.getInt("id"),weightClient);

            int id=generateId();
            Customer customer = new Customer(/*id*/result.getInt("id"), result.getString("name"), result.getDouble("rate"),
                    result.getString("typeloan"), result.getInt("qualitycategory"), result.getDate("dateloanto"),
                    result.getDate("dateloanfrom"), result.getInt("loanamount"),weightClient);
            customers.add(customer);
            mapCustomers.put(/*result.getInt("id")*/id, customer);
        }
        System.out.println("Данные успешно считаны! ");
        idTask = 0;
    }


    private Integer generateId() {
        idTask++;
        return idTask;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Map<Integer, Customer> getMapCustomers() {
        return mapCustomers;
    }

    public void setMapCustomers(Map<Integer, Customer> mapCustomers) {
        this.mapCustomers = mapCustomers;
    }

    public static String getDbUsername() {
        return DB_USERNAME;
    }

    public static String getDbPassword() {
        return DB_PASSWORD;
    }

    public static String getDbUrl() {
        return DB_URL;
    }
/*
    public Map<Integer, Double> getCustomersWeight() {
        return customersWeight;
    }

    public void setCustomersWeight(Map<Integer, Double> customersWeight) {
        this.customersWeight = customersWeight;
    }
    */
}
