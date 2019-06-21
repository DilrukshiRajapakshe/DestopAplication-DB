package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity;

public class qulification extends SuperEntity {
    private String Sid;
    private String filed;
    private String year;
    private String result;
    private String institiute;
    private String any;

    public qulification() {
    }

    public qulification(String sid, String filed, String year, String result, String institiute, String any) {
        Sid = sid;
        this.filed = filed;
        this.year = year;
        this.result = result;
        this.institiute = institiute;
        this.any = any;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        Sid = sid;
    }

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getInstitiute() {
        return institiute;
    }

    public void setInstitiute(String institiute) {
        this.institiute = institiute;
    }

    public String getAny() {
        return any;
    }

    public void setAny(String any) {
        this.any = any;
    }

    @Override
    public String toString() {
        return "qulificationDTO{" +
                "Sid='" + Sid + '\'' +
                ", filed='" + filed + '\'' +
                ", year='" + year + '\'' +
                ", result='" + result + '\'' +
                ", institiute='" + institiute + '\'' +
                ", any='" + any + '\'' +
                '}';
    }
}
