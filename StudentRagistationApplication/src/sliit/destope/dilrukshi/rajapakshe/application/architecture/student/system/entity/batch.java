package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity;

public class batch extends SuperEntity{
    private String Bid;
    private String Cid;
    private String Sdate;
    private String Bdisc;
    private int Samount;

    public batch() {
    }

    public batch(String bid, String cid, String sdate, String cdisc, int samount) {
        Bid = bid;
        Cid = cid;
        Sdate = sdate;
        Bdisc = cdisc;
        Samount = samount;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String bid) {
        Bid = bid;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getSdate() {
        return Sdate;
    }

    public void setSdate(String sdate) {
        Sdate = sdate;
    }

    public String getBdisc() {
        return Bdisc;
    }

    public void setBdisc(String cdisc) {
        Bdisc = cdisc;
    }

    public int getSamount() {
        return Samount;
    }

    public void setSamount(int samount) {
        Samount = samount;
    }

    @Override
    public String toString() {
        return "batchDTO{" +
                "Bid='" + Bid + '\'' +
                ", Cid='" + Cid + '\'' +
                ", Sdate='" + Sdate + '\'' +
                ", Cdisc='" + Bdisc + '\'' +
                ", Samount='" + Samount + '\'' +
                '}';
    }
}
