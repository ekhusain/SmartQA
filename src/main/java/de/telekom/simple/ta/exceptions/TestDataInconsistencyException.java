package de.telekom.simple.ta.exceptions;

public class TestDataInconsistencyException extends SimpleTestAutomationSystemException
{
    /**
     * 
     */
    private static final long serialVersionUID = -1376008996921087904L;

    /**
     * Exception with message.
     * 
     * @param message The message that should displayed.
     */
    public TestDataInconsistencyException(String message)
    {
        super(message);
    }

    /**
     * Exception with message and cause.
     * 
     * @param message The message that should displayed.
     * @param cause The Throwable of the exception.
     */
    public TestDataInconsistencyException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

    /**
     * Exception with cause.
     * 
     * @param cause The Throwable of the exception.
     */
    public TestDataInconsistencyException(final Throwable cause)
    {
        super(cause);
    }
}
