package sliit.destope.dilrukshi.rajapakshe.dto;

public class supplerDTO extends SuperDTO{
    private String Sid;
    private String fullName;
    private String position;
    private String postCord;
    private String address;
    private String city;
    private String email;
    private int Mtel;
    private String Cname;
    private String cEmail;
    private int cTel;

    public supplerDTO() {
    }

    public supplerDTO(String sid, String fullName, String position, String postCord, String address, String city,
                   String email, int mtel, String cname, String cEmail, int cTel) {
        Sid = sid;
        this.fullName = fullName;
        this.position = position;
        this.postCord = postCord;
        this.address = address;
        this.city = city;
        this.email = email;
        Mtel = mtel;
        Cname = cname;
        this.cEmail = cEmail;
        this.cTel = cTel;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        Sid = sid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPostCord() {
        return postCord;
    }

    public void setPostCord(String postCord) {
        this.postCord = postCord;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMtel() {
        return Mtel;
    }

    public void setMtel(int mtel) {
        Mtel = mtel;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public int getCTel() {
        return cTel;
    }

    public void setCTel(int cTel) {
        this.cTel = cTel;
    }

    @Override
    public String toString() {
        return "supplerDTO{" +
                "Sid='" + Sid + '\'' +
                ", fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", postCord='" + postCord + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", Mtel=" + Mtel +
                ", Cname='" + Cname + '\'' +
                ", cEmail='" + cEmail + '\'' +
                ", cTel=" + cTel +
                '}';
    }
}
