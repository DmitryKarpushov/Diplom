import database.DataBase;
import database.WorksBD;
import service.Calculator;
import service.WorkClients;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Консольное приложение");
        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        Calculator calculator = new Calculator();
        WorksBD worksBD = new WorksBD(scanner);
        WorkClients workClients = new WorkClients();
        printMenu();
        while (true) {
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    dataBase.readingBD();
                    printMenu();
                    break;
                case 2:
                    System.out.println("Введите id клиента");
                    int id = scanner.nextInt();
                    calculator.survey(dataBase.getMapCustomers(),id);
                    printMenu();
                    break;
                case 3:
                    System.out.println("Добавление клиента с данными");
                    System.out.println("Добавили клиента : "+worksBD.insertRecord());
                    printMenu();
                    break;
                case 4:
                    System.out.println("Удаление клиента из базы : ");
                    worksBD.deleteRecord();
                    printMenu();
                    break;
                case 5:
                    System.out.println("Вывод списка клиентов : ");
                    workClients.printClients(dataBase.getMapCustomers());
                    printMenu();
                    break;
                case 6:
                    System.out.println("Вывод списка ребер: ");
                    workClients.printWeightClients(dataBase.getCustomersWeight());
                    printMenu();
                    break;
                case 7:
                    printMenu();
                    break;
                case 8:
                    printMenu();
                    break;
                case 9:
                    System.out.println("Выход из приложения!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Введена неверная команда!");
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? Выберите действия : ");
        System.out.println("1 - Считать данные");
        System.out.println("2 - Вывод анкеты клиента с заявкой");
        System.out.println("3 - Добавить клиента в базу");
        System.out.println("4 - Удалить клиента из базы");
        System.out.println("5 - Печать списка клиентов");
        System.out.println("6 - Вывод списка весов рёбер");
        System.out.println("7 - ");
        System.out.println("8 - Вывести меню");
        System.out.println("9 - Выйти из приложения");
    }
}
