package exceptions;

public class PaidAmountNotEnoughException extends Exception {
    public PaidAmountNotEnoughException(String message){
        super(message);
    }
}
