package se.kth.iv1350.controller;

/**
 * This exception thrown when an operation fails for unknown reason.
 */
public class OperationFailedException extends Exception {

    /**
     * This constructor creates a new instance of the CodeExceptions class.
     * @param message The exception message.
     * @param cause The exception cause that will be shown to the user.
     */
    public OperationFailedException(String message, Exception cause){
        super(message,cause);
    }
}
