package sliit.destope.dilrukshi.rajapakshe.entity;

public class attendedFK {

    private String tdate;
    private String eid;

    public attendedFK(String tdate,String eid) {

        this.tdate=tdate;
        this.eid = eid;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String date) {
        this.tdate = date;
    }

    @Override
    public String toString() {
        return "attendedFK{" +
                "tdate='" + tdate + '\'' +
                ", eid='" + eid + '\'' +
                '}';
    }
}
