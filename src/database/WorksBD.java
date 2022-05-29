package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class WorksBD implements ActionsBD {
    Connection connection = DriverManager.getConnection(DataBase.getDbUrl(), DataBase.getDbUsername(), DataBase.getDbPassword());

    private Scanner scanner;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public WorksBD(Scanner scanner) throws SQLException {
        this.scanner = scanner;
    }
    @Override
    public String insertRecord() throws ParseException, SQLException {
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите % ставку:");
        double rate = scanner.nextDouble();
        System.out.println("Введите тип кредита:");
        String typeLoan = scanner.next();
        System.out.println("Введите категорию качества:");
        int qualityCategory = scanner.nextInt();
        System.out.println("Введите дату начала кредитного периода:");
        String dateLoanTo = scanner.next();
        Date dateTo = formatter.parse(dateLoanTo);
        java.sql.Date sqlDateTo = new java.sql.Date(dateTo.getTime());
        System.out.println("Введите дату окончания кредитного периода:");
        String dateLoanFrom = scanner.next();
        Date dateFrom = formatter.parse(dateLoanFrom);
        java.sql.Date sqlDateFrom = new java.sql.Date(dateFrom.getTime());
        System.out.println("Введите сумму кредита:");
        double loanAmount = scanner.nextDouble();
        String SQL_INSERT_REQUESTSCUSTOMER = "insert into requestscustomer(id,name,rate,typeLoan,qualityCategory,dateLoanTo,dateLoanFrom,loanAmount) " +
                "values(nextval('req_cus_id'),?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_REQUESTSCUSTOMER);
        preparedStatement.setString(1, name);
        preparedStatement.setDouble(2, rate);
        preparedStatement.setString(3, typeLoan);
        preparedStatement.setInt(4, qualityCategory);
        preparedStatement.setDate(5, sqlDateTo);
        preparedStatement.setDate(6, sqlDateFrom);
        preparedStatement.setDouble(7, loanAmount);
        preparedStatement.executeUpdate();

        return name;
    }
    @Override
    public void deleteRecord() throws SQLException {
        System.out.println("Введите id клиента которого хотите удалить из списки на выдачу кредита :");
        int id = scanner.nextInt();
        String SQL_DELETE_REQUESTSCUSTOMER = "DELETE FROM requestscustomer WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_REQUESTSCUSTOMER);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

    }
}
