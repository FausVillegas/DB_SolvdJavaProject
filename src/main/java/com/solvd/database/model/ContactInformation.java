package main.java.com.solvd.database.model;

public class ContactInformation {
    String email;
    Long phoneNumber;
    int userId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}