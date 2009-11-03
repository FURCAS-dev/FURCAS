package com.sap.tc.moin.repository.mmi.reflect;

/**
 * Is raised when a client attempts to create a second instance of an M2 class
 * whose <code>isSingleton</code> is set to true.
 */
public class AlreadyExistsException extends JmiException {

    private static final long serialVersionUID = 1L;

    volatile private RefObject existing;

    /**
     * Constructs a new <code>AlreadyExistsException</code> without detail
     * message.
     * 
     * @param existingObject existing singleton instance
     */
    public AlreadyExistsException( RefObject existingObject ) {

        super( existingObject.refMetaObject( ), JmiExceptionMessages.OBJECTALREADYEXISTS, existingObject.get___Mri( ).toString( ) );
        this.existing = existingObject;
    }

    /**
     * Returns existing instance of singleton.
     * 
     * @return existing singleton instance
     */
    public RefObject getExistingInstance( ) {

        return this.existing;
    }
}