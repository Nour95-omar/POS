package se.kth.iv1350.integration;
/**
 * Thrown when something goes wrong while performing an
 * operation in the database.
 */
public class DatabaseFailureException extends RuntimeException {

    /**
     * Creates a new instance representing the condition
     * described in the specified message.
     *
     * @param message A message that describes what went wrong.
     */
    public DatabaseFailureException (String message){
        super("The system could not contact the database, please try again");
    }
}
