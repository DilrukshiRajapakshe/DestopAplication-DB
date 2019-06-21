package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto;

public class batchDTO extends SuperDTO {
    private String Bid;
    private String Cid;
    private String Sdate;
    private String Bdisc;
    private int Samount;

    public batchDTO() {
    }

    public batchDTO(String bid, String cid, String sdate, String bdisc, int samount) {
        Bid = bid;
        Cid = cid;
        Sdate = sdate;
        Bdisc = bdisc;
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
