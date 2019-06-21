package sliit.destope.dilrukshi.rajapakshe.entity;

public class rent_stock extends SuperEntity{
    private String Iid;
    private String Iname;
    private String Sid;
    private double buyPrice;
    private double discount;
    private int amount;
    private String brand;
    private double rentPrice;

    public rent_stock(String iid, String iname, String sid, double buyPrice, double discount, int amount,
                      String brand, double rentPrice) {
        Iid = iid;
        Iname = iname;
        Sid = sid;
        this.buyPrice = buyPrice;
        this.discount = discount;
        this.amount = amount;
        this.brand = brand;
        this.rentPrice = rentPrice;
    }

    public rent_stock() {
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

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        Sid = sid;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    @Override
    public String toString() {
        return "rent_stock{" +
                "Iid='" + Iid + '\'' +
                ", Iname='" + Iname + '\'' +
                ", Sid='" + Sid + '\'' +
                ", buyPrice=" + buyPrice +
                ", discount=" + discount +
                ", amount=" + amount +
                ", brand='" + brand + '\'' +
                ", rentPrice=" + rentPrice +
                '}';
    }
}
