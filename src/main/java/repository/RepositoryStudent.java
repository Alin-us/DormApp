package repository;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import starter.HibernateUtils;

import java.util.List;

public class RepositoryStudent {
    Session session;
    Transaction transaction;

    public Integer saveStudent(Student student) {
        openSesion();
        Integer idStudent = (Integer) session.save(student);
        closeSession();
        return idStudent;
    }

    public void deleteStudent(Student student) {
        openSesion();
        session.delete(student);
        session.close();
    }

    public Student findStudentById(int idStudent) {
        openSesion();
        Student student = session.find(Student.class, idStudent);
        closeSession();
        return student;
    }//trifan.c_madalina@yahoo.com

    public boolean uniqueStudent(Student student) {
        openSesion();
        Query q = session.createQuery("from Student as s where s.email=:emailTable and s.firstName=:nameFirstTable and s.lastName=:lastNameTable");
        q.setParameter("emailTable",student.getEmail());
        q.setParameter("nameFirstTable",student.getFirstName());
        q.setParameter("lastNameTable",student.getLastName());
        List list = q.list();
        return (list.size() == 0);
    }

    public void openSesion() {
        session = HibernateUtils.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public void closeSession() {
        transaction.commit();
        session.close();
    }
}
