package sliit.destope.dilrukshi.rajapakshe.view.Table;

public class paymentStockTB {
    private String Iid;
    private String Iname;
    private double sellingPrice;
    private double discount;
    private int sellQty;
    private String brand;
    private double total;

    public paymentStockTB() {
    }

    public paymentStockTB(String iid, String iname, double sellingPrice, double discount, int sellQty, String brand,
                          double total) {
        Iid = iid;
        Iname = iname;
        this.sellingPrice = sellingPrice;
        this.discount = discount;
        this.sellQty = sellQty;
        this.brand = brand;
        this.total = total;
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

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "paymentStockTB{" +
                "Iid='" + Iid + '\'' +
                ", Iname='" + Iname + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", discount=" + discount +
                ", sellQty=" + sellQty +
                ", brand='" + brand + '\'' +
                ", total=" + total +
                '}';
    }
}
