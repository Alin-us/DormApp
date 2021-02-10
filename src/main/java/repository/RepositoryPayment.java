package repository;

import model.Payment;
import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import starter.HibernateUtils;

public class RepositoryPayment {
    Session session;
    Transaction transaction;
    public void savePayment(Payment payment){
        openSession();
        session.save(payment);
        closeSession();
    }
    public  void deletePayment(Payment payment){
        openSession();
        session.delete(payment);
        closeSession();
    }
    public  void addAmountPaid(Payment payment,double amountPaid){
        openSession();
        payment.setAmountPaid(amountPaid);
        session.update(payment);
        closeSession();
    }
    public void setPaymentTrue(Payment payment){
        openSession();
        payment.setPaid(true);
        session.update(payment);
        closeSession();
    }
    public Payment fiindPaymentByStudent(Student student){
        openSession();
        Query q=session.createQuery("from Payment p where p.student=:studentTable");
        q.setParameter("studentTable",student);
        return (Payment)q.getSingleResult();
    }

    public  void openSession(){
        session= HibernateUtils.getSessionFactory().openSession();
        transaction=session.beginTransaction();
    }
    public  void closeSession(){
        transaction.commit();
        session.close();
    }
}
