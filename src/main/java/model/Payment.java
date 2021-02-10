package model;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int paymentId;
    @OneToOne
    @JoinColumn(name = "studentId")
    private Student student;
    @Column
    private double amountToPay;
    @Column
    private double amountPaid;
    @Column
    private boolean paid;

    public Payment() {
    }

    public Payment(Student student, double amountToPay) {
        this.student = student;
        this.amountToPay = amountToPay;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
