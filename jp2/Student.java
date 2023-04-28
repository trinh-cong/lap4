package jp2;

public class Student {
    private String studentID;
    private String name;
    private String address;
    private String phone;

    public Student(String studentID, String name, String address, String phone) {
        this.studentID = studentID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String toString() {
        return studentID + "," + name + "," + address + "," + phone;
    }
}