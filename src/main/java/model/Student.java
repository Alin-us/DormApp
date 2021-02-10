package model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String faculty;
    @Column
    private int accommodationNorm;
    @OneToOne(mappedBy = "student")
    private Payment payment;


    public Student() {
    }

    public Student(String firstName, String lastName, String email, String faculty, int accommodationNorm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.faculty = faculty;
        this.accommodationNorm = accommodationNorm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getAccommodationNorm() {
        return accommodationNorm;
    }

    public void setAccommodationNorm(int accommodationNorm) {
        this.accommodationNorm = accommodationNorm;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
