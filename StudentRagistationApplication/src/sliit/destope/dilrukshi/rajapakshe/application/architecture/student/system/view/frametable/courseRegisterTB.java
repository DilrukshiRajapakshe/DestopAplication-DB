package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable;

public class courseRegisterTB {

    private String Cid;
    private String Cname;
    private String Cdura;
    private String Bid;
    private String Bdisc;
    private int Samount;
    private String Sdate;
    private String Cdis;

    public courseRegisterTB() {
    }

    public courseRegisterTB(String cid, String cname, String cdura, String bid, String bdisc,
                            int samount, String sdate, String cdis) {
        Cid = cid;
        Cname = cname;
        Cdura = cdura;
        Bid = bid;
        Bdisc = bdisc;
        Samount = samount;
        Sdate = sdate;
        Cdis = cdis;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCdura() {
        return Cdura;
    }

    public void setCdura(String cdura) {
        Cdura = cdura;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String bid) {
        Bid = bid;
    }

    public String getBdisc() {
        return Bdisc;
    }

    public void setBdisc(String bdisc) {
        Bdisc = bdisc;
    }

    public int getSamount() {
        return Samount;
    }

    public void setSamount(int samount) {
        Samount = samount;
    }

    public String getSdate() {
        return Sdate;
    }

    public void setSdate(String sdate) {
        Sdate = sdate;
    }

    public String getCdis() {
        return Cdis;
    }

    public void setCdis(String cdis) {
        Cdis = cdis;
    }

    @Override
    public String toString() {
        return "courseRegisterTB{" +
                "Cid='" + Cid + '\'' +
                ", Cname='" + Cname + '\'' +
                ", Cdura='" + Cdura + '\'' +
                ", Bid='" + Bid + '\'' +
                ", Bdisc='" + Bdisc + '\'' +
                ", Samount=" + Samount +
                ", Sdate='" + Sdate + '\'' +
                ", Cdis='" + Cdis + '\'' +
                '}';
    }
}
