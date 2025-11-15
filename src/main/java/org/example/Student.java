package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "stud_table") //if  not added, by default creates with class name
public class Student {

    @Id
    private int sRollNo;

    @Column(name = "name")
    private String sName;

    @Transient //this won't include in adding column
    private int sAge;

    public int getsRollNo() {
        return sRollNo;
    }

    public void setsRollNo(int sRollNo) {
        this.sRollNo = sRollNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sRollNo=" + sRollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                '}';
    }
}
