package de.telekom.simple.ta.exceptions;

public class SimpleTestAutomationSystemException extends RuntimeException
{
    /**
     * 
     */
    private static final long serialVersionUID = 680109092811805851L;

    /**
     * Exception with message.
     * 
     * @param message The message that should displayed.
     */
    public SimpleTestAutomationSystemException(final String message)
    {
        super(message);
    }

    /**
     * Exception with message and cause.
     * 
     * @param message The message that should displayed.
     * @param cause The Throwable of the exception.
     */
    public SimpleTestAutomationSystemException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

    /**
     * Exception with cause.
     * 
     * @param cause The Throwable of the exception.
     */
    public SimpleTestAutomationSystemException(final Throwable cause)
    {
        super(cause);
    }

}
