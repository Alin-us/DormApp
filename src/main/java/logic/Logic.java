package logic;

import exceptions.PaidAmountNotEnoughException;
import exceptions.StudentAllreadyRegistredException;
import model.Payment;
import model.Student;
import repository.RepositoryPayment;
import repository.RepositoryStudent;

public class Logic {
    RepositoryPayment repositoryPayment = new RepositoryPayment();
    RepositoryStudent repositoryStudent = new RepositoryStudent();
    MailSender mailSender = new MailSender();

    public Logic() {
    }

    public int registerStudent(Student student) throws StudentAllreadyRegistredException {//salveaza un student si slotul aferent platii in payment
        if (repositoryStudent.uniqueStudent(student)) {
            int idStudent = repositoryStudent.saveStudent(student);
            if (student.getAccommodationNorm() == 1) {
                Payment payment = new Payment(student, 250);
                repositoryPayment.savePayment(payment);
                mailSender.sendRegistrationMail(student.getEmail(), idStudent, student.getAccommodationNorm(), student.getEmail(), student.getFaculty(), student.getFirstName(), student.getLastName(), payment.getAmountToPay());
            } else if (student.getAccommodationNorm() == 2) {
                Payment payment = new Payment(student, 180);
                repositoryPayment.savePayment(payment);
                mailSender.sendRegistrationMail(student.getEmail(), idStudent, student.getAccommodationNorm(), student.getEmail(), student.getFaculty(), student.getFirstName(), student.getLastName(), payment.getAmountToPay());
            } else {
                Payment payment = new Payment(student, 125);
                repositoryPayment.savePayment(payment);
                mailSender.sendRegistrationMail(student.getEmail(), idStudent, student.getAccommodationNorm(), student.getEmail(), student.getFaculty(), student.getFirstName(), student.getLastName(), payment.getAmountToPay());
            }
            return idStudent;
        } else {
            throw new StudentAllreadyRegistredException("Allready an existing account for this student!");
        }
    }

    public double getAmountToPay(int studentId) {
        return repositoryPayment.fiindPaymentByStudent(repositoryStudent.findStudentById(studentId)).getAmountToPay();
    }

    public double addTheAmountPaidInTheDatabase(double amountPaid, int idStudent) throws PaidAmountNotEnoughException {
        Payment payment = repositoryPayment.fiindPaymentByStudent(repositoryStudent.findStudentById(idStudent));
        if (amountPaid >= payment.getAmountToPay()) {
            repositoryPayment.addAmountPaid(payment, amountPaid);
            repositoryPayment.setPaymentTrue(payment);
            Student student = repositoryStudent.findStudentById(idStudent);
            mailSender.sendPaymentMail(student.getEmail(), idStudent, student.getAccommodationNorm(), student.getEmail(), student.getFaculty(), student.getFirstName(), student.getLastName(), amountPaid);
        } else {
            throw new PaidAmountNotEnoughException("You need to pay more money!");
        }
        return calculateChange(payment);
    }

    public double calculateChange(Payment payment) {
        return payment.getAmountPaid() - payment.getAmountToPay();
    }


}
