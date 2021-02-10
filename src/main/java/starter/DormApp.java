package starter;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import logic.Logic;
import logic.MailSender;
import model.Student;

import java.util.Scanner;

public class DormApp {
    public static void main(String[] args) {
        HibernateUtils.getSessionFactory();
        Logic logic = new Logic();
//        System.out.println("Introduceti-va numele: ");
//        Scanner sc = new Scanner(System.in);
//        String firstName = sc.nextLine();
//        System.out.println("Introduceti-va prenumele: ");
//        String lastName = sc.nextLine();
//        System.out.println("Introduceti-va emailul: ");
//        String email = sc.nextLine();
//        System.out.println("Introduceti-va Facultatea: ");
//        String faculty = sc.nextLine();
//        System.out.println("Introduceti-va norma de cazare 1-4: ");
//        int accomodationNorm = sc.nextInt();
//        Student student = new Student(firstName, lastName, email, faculty, accomodationNorm);
//        try {
//            System.out.println("Id ul dumneavoastra de student este : " + logic.registerStudent(student) + " Datele contului vor fi transmise prin intermediul adresei de mail introdusa la creearea contului.");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Plata regiei de camin");
        System.out.println("Introduceti-va Id-ul: ");
        int idStudent = sc1.nextInt();
        System.out.println("Aveti de plata:" + logic.getAmountToPay(idStudent));
        System.out.println("Doriti sa platiti?");
        Scanner sc2 = new Scanner(System.in);
        String wantToPay = sc2.nextLine();
        System.out.println("Introduceti suma:");
        double paidAmount = sc1.nextDouble();
        try {
            if (wantToPay.equals("da")) {
                double change=logic.addTheAmountPaidInTheDatabase(paidAmount, idStudent);
                System.out.println(String.format("Restul tranzactiei dumneavoastra este de: %s  lei",change));
            }else {
                System.out.println("La revedere!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
