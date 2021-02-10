package logic;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {
    public void sendRegistrationMail(String to,int studentId,int accomodationNorm,String email,String faculty,String firstName,String lastName,double amountToPay) {
        // Recipient's email ID needs to be mentioned.
//        to = "otherEmail@gmail.com";
        // Sender's email ID needs to be mentioned
        String from = "SenderMail@gmai.com";
        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("SenderMail@gmai.com", "password");
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("otherEmails@gmail.com"));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Inregistrare platforma plata");
            // Now set the actual message
            message.setText("Buna ziua!Ne bucuram ca ati ales plata online a regiei pentru camin!" +
                    "\nNumarul de identificare unic de student este: "+studentId+"\nPrenume: "+firstName+"\n Nume:"+lastName+
                    "\nMail: "+email+"\nSuma lunara solicitata este conform grilei de regie :"+amountToPay+"\nPentru efectuarea platilor va rugam sa pastrati acest email sau sa retineti numarul unic si specific de identificare.");
            // Send message
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    public void sendPaymentMail(String to,int studentId,int accomodationNorm,String email,String faculty,String firstName,String lastName,double amountToPay) {
        // Recipient's email ID needs to be mentioned.
//        to = "otherEmails@gmail.com";
        // Sender's email ID needs to be mentioned
        String from = "SenderMail@gmail.com";
        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("SenderMail@gmai.com", "password");
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("otherEmails@gmail.com"));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Inregistrare platforma plata");
            // Now set the actual message
            message.setText("Buna ziua!Ne bucuram ca ati ales plata online a regiei pentru camin!\n" +
                    "Plata a fost efectuata cu succes in contul  studentul: "+studentId+"\nPrenume: "+firstName+"\n Nume:"+lastName+
                    "\nMail: "+email+"\n.Suma achitata este de: "+amountToPay+" lei.");
            // Send message
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
