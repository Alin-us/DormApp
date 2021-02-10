package exceptions;

public class StudentAllreadyRegistredException extends Exception {
    public StudentAllreadyRegistredException(String message){
        super(message);
    }
}
