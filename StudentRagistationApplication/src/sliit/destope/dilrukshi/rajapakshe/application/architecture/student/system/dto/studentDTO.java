package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto;

public class studentDTO extends SuperDTO {

    private String Sid;
    private String SinName;
    private String SfuName;
    private String Sadd;
    private String Scity;
    private String Htel;
    private String Mtel;
    private String email;
    private String DofB;
    private String gender;

    public studentDTO() {
    }

    public studentDTO(String sid, String sinName, String sfuName, String sadd,
                      String scity, String htel, String mtel, String email, String dofB, String gender) {
        Sid = sid;
        SinName = sinName;
        SfuName = sfuName;
        Sadd = sadd;
        Scity = scity;
        Htel = htel;
        Mtel = mtel;
        this.email = email;
        DofB = dofB;
        this.gender = gender;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        Sid = sid;
    }

    public String getSinName() {
        return SinName;
    }

    public void setSinName(String sinName) {
        SinName = sinName;
    }

    public String getSfuName() {
        return SfuName;
    }

    public void setSfuName(String sfuName) {
        SfuName = sfuName;
    }

    public String getSadd() {
        return Sadd;
    }

    public void setSadd(String sadd) {
        Sadd = sadd;
    }

    public String getScity() {
        return Scity;
    }

    public void setScity(String scity) {
        Scity = scity;
    }

    public String getHtel() {
        return Htel;
    }

    public void setHtel(String htel) {
        Htel = htel;
    }

    public String getMtel() {
        return Mtel;
    }

    public void setMtel(String mtel) {
        Mtel = mtel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDofB() {
        return DofB;
    }

    public void setDofB(String dofB) {
        DofB = dofB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "studentDTO{" +
                "Sid='" + Sid + '\'' +
                ", SinName='" + SinName + '\'' +
                ", SfuName='" + SfuName + '\'' +
                ", Sadd='" + Sadd + '\'' +
                ", Scity='" + Scity + '\'' +
                ", Htel='" + Htel + '\'' +
                ", Mtel='" + Mtel + '\'' +
                ", email='" + email + '\'' +
                ", DofB='" + DofB + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
