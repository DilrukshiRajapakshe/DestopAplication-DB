package sliit.destope.dilrukshi.rajapakshe.entity;

public class damage_stock extends SuperEntity{
    private String Iid;
    private String Iname;
    private String Sid;
    private double buyPrice;
    private int amount;
    private String brand;

    public damage_stock(String iid, String iname, String sid, double buyPrice, int amount, String brand) {
        Iid = iid;
        Iname = iname;
        Sid = sid;
        this.buyPrice = buyPrice;
        this.amount = amount;
        this.brand = brand;
    }

    public damage_stock() {
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

    @Override
    public String toString() {
        return "damage_stock{" +
                "Iid='" + Iid + '\'' +
                ", Iname='" + Iname + '\'' +
                ", Sid='" + Sid + '\'' +
                ", buyPrice=" + buyPrice +
                ", amount=" + amount +
                ", brand='" + brand + '\'' +
                '}';
    }
}
