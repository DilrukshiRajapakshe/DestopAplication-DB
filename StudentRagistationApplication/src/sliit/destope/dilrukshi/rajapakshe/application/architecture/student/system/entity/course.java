package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity;

public class course extends SuperEntity{
    private String Cid;
    private String Cname;
    private String Cdis;
    private String Cdura;

    public course() {
    }

    public course(String cid, String cname, String cdis, String cdura) {
        Cid = cid;
        Cname = cname;
        Cdis = cdis;
        Cdura = cdura;
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

    public String getCdis() {
        return Cdis;
    }

    public void setCdis(String cdis) {
        Cdis = cdis;
    }

    public String getCdura() {
        return Cdura;
    }

    public void setCdura(String cdura) {
        Cdura = cdura;
    }

    @Override
    public String toString() {
        return "courseDTO{" +
                "Cid='" + Cid + '\'' +
                ", Cname='" + Cname + '\'' +
                ", Cdis='" + Cdis + '\'' +
                ", Cdura='" + Cdura + '\'' +
                '}';
    }
}
