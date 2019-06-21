package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto;

public class parentDTO extends SuperDTO {

    private String Sid;
    private String Pname;
    private String Mtel;
    private String Ptel;
    private String Pemail;
    private String Pposition;
    private String PworkPlase;
    private String Paddress;

    public parentDTO() {
    }

    public parentDTO(String sid, String pname, String mtel, String ptel,
                     String pemail, String pposition, String pworkPlase, String paddress) {
        Sid = sid;
        Pname = pname;
        Mtel = mtel;
        Ptel = ptel;
        Pemail = pemail;
        Pposition = pposition;
        PworkPlase = pworkPlase;
        Paddress = paddress;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        Sid = sid;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getMtel() {
        return Mtel;
    }

    public void setMtel(String mtel) {
        Mtel = mtel;
    }

    public String getPtel() {
        return Ptel;
    }

    public void setPtel(String ptel) {
        Ptel = ptel;
    }

    public String getPemail() {
        return Pemail;
    }

    public void setPemail(String pemail) {
        Pemail = pemail;
    }

    public String getPposition() {
        return Pposition;
    }

    public void setPposition(String pposition) {
        Pposition = pposition;
    }

    public String getPworkPlase() {
        return PworkPlase;
    }

    public void setPworkPlase(String pworkPlase) {
        PworkPlase = pworkPlase;
    }

    public String getPaddress() {
        return Paddress;
    }

    public void setPaddress(String paddress) {
        Paddress = paddress;
    }

    @Override
    public String toString() {
        return "parentDTO{" +
                "Sid='" + Sid + '\'' +
                ", Pname='" + Pname + '\'' +
                ", Mtel='" + Mtel + '\'' +
                ", Ptel='" + Ptel + '\'' +
                ", Pemail='" + Pemail + '\'' +
                ", Pposition='" + Pposition + '\'' +
                ", PworkPlase='" + PworkPlase + '\'' +
                ", Paddress='" + Paddress + '\'' +
                '}';
    }
}
