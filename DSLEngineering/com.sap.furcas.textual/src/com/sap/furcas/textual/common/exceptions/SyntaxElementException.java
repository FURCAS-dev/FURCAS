/**
 * 
 */
package com.sap.furcas.textual.common.exceptions;


/**
 *
 */
public class SyntaxElementException extends AbstractToolGenerationException {

    /**
     * 
     */
    private static final long serialVersionUID = 89381211050690798L;
    
    private Object syntaxModelElement;

    /**
     * 
     * @param message
     * @param syntaxModelElement the element of the syntax which caused the error
     */
    public SyntaxElementException(String message, Object syntaxModelElement) {
        this(message, syntaxModelElement, null);
        if (syntaxModelElement instanceof Throwable) {
            throw new RuntimeException("Illegal usage of constructor, use SyntaxElementException(String, Object, Throwable) instead");
        }
    }

    /**
     * 
     * @param message
     * @param syntaxModelElement the element of the syntax which caused the error
     * @param cause the exception that happened while trying to do something with the object
     */
    public SyntaxElementException(String message, Object syntaxModelElement, Throwable cause) {
        super(message, cause);
        this.syntaxModelElement = syntaxModelElement;
    }

    public Object getSyntaxModelElement() {
        return syntaxModelElement;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SyntaxElementException) {
            SyntaxElementException other = (SyntaxElementException) obj;
            return (this.syntaxModelElement.equals(other.syntaxModelElement) && this.getMessage().equals(other.getMessage()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    
    
    
}
