package service;

import api.Customer;
import java.sql.Date;
import java.util.Map;

public class Calculator {
    private int MILLISECOND = 86400000;
    private int percent = 100;

    public void survey(Map<Integer, Customer> mapCustomers, int id) {
        System.out.println("Клиент : "+mapCustomers.get(id).getName());
        System.out.println("Процентная ставка : "+ mapCustomers.get(id).getRate());
        System.out.println("Тип кредита : " + mapCustomers.get(id).getTypeLoan());
        System.out.println("Категория качества : " + mapCustomers.get(id).getQualityCategory());
        System.out.println("Дата начала кредитного периода "+mapCustomers.get(id).getDateLoanTo());
        System.out.println("Дата окончания кредитного периода "+mapCustomers.get(id).getDateLoanFrom());
        Date firstDate = mapCustomers.get(id).getDateLoanTo();
        Date secondDate = mapCustomers.get(id).getDateLoanFrom();
        long delt = (secondDate.getTime() - firstDate.getTime()) / MILLISECOND;
        double sumLoan = mapCustomers.get(id).getLoanAmount() * (delt / 365) * mapCustomers.get(id).getRate() / percent;
        System.out.println("Кредитный период в днях : " + delt);
        System.out.println("Сумма процентов по договору займа : " + sumLoan);
    }

    public int getMILLISECOND() {
        return MILLISECOND;
    }

    public void setMILLISECOND(int MILLISECOND) {
        this.MILLISECOND = MILLISECOND;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
