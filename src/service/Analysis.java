package service;

import api.Customer;

import java.util.Map;

public class Analysis {
    int count;

    public void Test(Map<Integer, Customer> mapCustomers) {
        count = mapCustomers.size() + 1;
        System.out.println("Количество вершин : " + count);
        GFG.Graph graph = new GFG.Graph(count);

        // for (Map.Entry<Integer, Double> client : customersWeight.entrySet()) {
        // graph.addEdge(u,v,client.getValue(),"Test");
          /*  graph.addEdge(0, 1, (double) 113, "Test");
            graph.addEdge(0, 2, (double)222, "Test");
            graph.addEdge(0, 3, (double)667, "Test");
            graph.addEdge(0, 4, (double)989, "Test");
            graph.addEdge(1, 5, (double)554, "Test");
            graph.addEdge(5, 6, (double)333, "Test");
            graph.addEdge(5, 7, (double)445, "Test");
            graph.addEdge(2, 8, (double)223, "Test");
            graph.addEdge(2, 9, (double)224, "Test"); */
        // System.out.println("Ключ " + client.getKey() + " " + " Значение " + client.getValue());
        // u++;
        // v++;
        //  }
        int d = mapCustomers.size();
        /*
        for (int i =0 ;i< d +1;i++ ){
            for (int j=i+1 ;j< d +1 ;j++ ){
                System.out.println("i = " + i + " j = " + j);
                graph.addEdge(i, j, (double)222, "Test");
            }
        }
        */
       /* for (Map.Entry<Integer, Customer> customer : mapCustomers.entrySet()) {
            //System.out.println(customer.getKey()+ " Name = " + customer.getValue().getName() + " Вес = "+ customer.getValue().getCustomersWeight());
            int i=0;
            for (int j=i+1 ;j< d +1 ;j++ ){
                System.out.println("i = " + i + " j = " + j);
               // graph.addEdge(i, j, (double)222, "Test");
            }
            i++;
        } */
        /*for (Map.Entry<Integer, Customer> customer : mapCustomers.entrySet()) {
            System.out.println(customer.getKey()+ " Name = " + customer.getValue().getName() + " Вес = "+ customer.getValue().getCustomersWeight());

        }*/
       for (int i=0; i<d+1;i++){
           for (int j=i+1 ;j< d +1 ;j++ ){
               //System.out.println("i = " + i + " j = " + j+ " Name " + mapCustomers.get(j).getName() + " ВЕС = " + mapCustomers.get(j).getCustomersWeight());
               graph.addEdge(i,j,mapCustomers.get(j).getCustomersWeight(),mapCustomers.get(j).getName());
           }
       }


       // int s = 0;
        graph.longestPath(0);
    }
}


