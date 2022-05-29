package api;
import java.sql.Date;

public class Customer {
    private Integer id;
    private String name;
    private double rate;
    private String typeLoan;
    private Integer qualityCategory;
    private Date dateLoanTo;
    private Date dateLoanFrom;
    private double loanAmount;

    public Customer(Integer id, String name, double rate, String typeLoan, Integer qualityCategory, Date dateLoanTo, Date dateLoanFrom, double loanAmount) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.typeLoan = typeLoan;
        this.qualityCategory = qualityCategory;
        this.dateLoanTo = dateLoanTo;
        this.dateLoanFrom = dateLoanFrom;
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", typeLoan='" + typeLoan + '\'' +
                ", qualityCategory=" + qualityCategory +
                ", dateLoanTo=" + dateLoanTo +
                ", dateLoanFrom=" + dateLoanFrom +
                ", loanAmount=" + loanAmount +
                '}'+ '\n';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getTypeLoan() {
        return typeLoan;
    }

    public void setTypeLoan(String typeLoan) {
        this.typeLoan = typeLoan;
    }

    public Integer getQualityCategory() {
        return qualityCategory;
    }

    public void setQualityCategory(Integer qualityCategory) {
        this.qualityCategory = qualityCategory;
    }

    public Date getDateLoanTo() {
        return dateLoanTo;
    }

    public void setDateLoanTo(Date dateLoanTo) {
        this.dateLoanTo = dateLoanTo;
    }

    public Date getDateLoanFrom() {
        return dateLoanFrom;
    }

    public void setDateLoanFrom(Date dateLoanFrom) {
        this.dateLoanFrom = dateLoanFrom;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

}
