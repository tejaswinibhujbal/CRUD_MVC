package bank.model;
public class Update {
    private int accNo;
    private String uName;

    public Update(int accNo, String uName) {
        this.accNo = accNo;
        this.uName = uName;
    }

    // Getters and setters
    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}
