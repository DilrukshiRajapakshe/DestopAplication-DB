package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto;

public class choose_courseDTO extends SuperDTO{

    private String Sid;
    private String Cid;
    private String Bid;

    public choose_courseDTO() {
    }

    public choose_courseDTO(String sid, String cid, String bid) {
        setSid(sid);
        setCid(cid);
        setBid(bid);
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        Sid = sid;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String bid) {
        Bid = bid;
    }

    @Override
    public String toString() {
        return "choose_courseDTO{" +
                "Sid='" + getSid() + '\'' +
                ", Cid='" + getCid() + '\'' +
                ", Bid='" + getBid() + '\'' +
                '}';
    }
}
