package sliit.destope.dilrukshi.rajapakshe.entity;



public class login extends SuperEntity{

    private loginFK fk;
    private String nic;


    public login() {
    }

    public login(String userName, String password,String nic) {
        this.fk = new loginFK(userName,password);
        this.nic = nic;
    }

    public login(loginFK fk, String nic) {
        this.fk = fk;
        this.nic = nic;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public loginFK getFk() {
        return fk;
    }

    public void setFk(loginFK fk) {
        this.fk = fk;
    }

    @Override
    public String toString() {
        return "login{" +
                "fk=" + fk +
                ", nic='" + nic + '\'' +
                '}';
    }
}
