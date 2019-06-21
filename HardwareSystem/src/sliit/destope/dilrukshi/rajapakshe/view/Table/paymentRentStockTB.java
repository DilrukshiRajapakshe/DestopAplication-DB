package sliit.destope.dilrukshi.rajapakshe.view.Table;

public class paymentRentStockTB {

    private String Iid;
    private String Iname;
    private double rentPrice;
    private double discount;
    private int sellQty;
    private int rentDate;
    private double total;

    public paymentRentStockTB(String iid, String iname, double rentPrice, double discount, int sellQty,
                              int rentDate, double total) {

        Iid = iid;
        Iname = iname;
        this.rentPrice = rentPrice;
        this.discount = discount;
        this.sellQty = sellQty;
        this.rentDate = rentDate;
        this.total = total;
    }

    public paymentRentStockTB() {
    }

    public String getIid() {
        return Iid;
    }

    public void setIid(String iid) {
        Iid = iid;
    }

    public String getIname() {
        return Iname;
    }

    public void setIname(String iname) {
        Iname = iname;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getSellQty() {
        return sellQty;
    }

    public void setSellQty(int sellQty) {
        this.sellQty = sellQty;
    }

    public int getRentDate() {
        return rentDate;
    }

    public void setRentDate(int rentDate) {
        this.rentDate = rentDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "paymentRentStockTB{" +
                ", Iid='" + Iid + '\'' +
                ", Iname='" + Iname + '\'' +
                ", rentPrice=" + rentPrice +
                ", discount=" + discount +
                ", sellQty=" + sellQty +
                ", rentDate=" + rentDate +
                ", total=" + total +
                '}';
    }
}
