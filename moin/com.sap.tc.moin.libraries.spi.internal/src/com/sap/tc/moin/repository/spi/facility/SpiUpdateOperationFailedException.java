package com.sap.tc.moin.repository.spi.facility;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * Thrown if a persistence update was not successfull. The exception potentially
 * contains more than one exception. The whole set of exceptions can be obtained
 * by going through the iterator (getIterator()).
 * 
 * @author d026715
 */
public class SpiUpdateOperationFailedException extends IOException {

    /**
     * Exception is serializable
     */
    private static final long serialVersionUID = 1L;

    PRI affectedPri;

    SpiUpdateOperationFailedException nextException;

    SpiUpdateOperationFailedException lastException;

    /**
     * See {@link IOException}.
     * 
     * @param rootCause see {@link IOException}
     * @param pri the offending PRI
     */
    public SpiUpdateOperationFailedException( Throwable rootCause, PRI pri ) {

        super( rootCause.getLocalizedMessage( ) );
        this.affectedPri = pri;
    }

    /**
     * Constructor
     * 
     * @param message The message of the exception
     * @param pri The identifier of the partition for that the operation fails
     */
    public SpiUpdateOperationFailedException( String message, PRI pri ) {

        super( message );
        this.affectedPri = pri;
    }

    /**
     * Get the offending PRI.
     * 
     * @return the offending PRI
     */
    public PRI getPri( ) {

        return this.affectedPri;
    }

    /**
     * Add an Exception.
     * 
     * @param ex the Exception to add
     */
    public void addException( SpiUpdateOperationFailedException ex ) {

        if ( this.lastException != null ) {
            this.lastException.addException( ex );
        } else {
            this.nextException = ex;
        }
        this.lastException = ex;
    }

    /**
     * Get the iterator of all exceptions.
     * 
     * @return the Iterator
     */
    public Iterator getIterator( ) {

        return new Iterator( ) {

            Object nextElement = SpiUpdateOperationFailedException.this;

            public boolean hasNext( ) {

                return ( this.nextElement != null );
            }

            public Object next( ) {

                if ( this.nextElement != null ) {
                    Object next = this.nextElement;
                    this.nextElement = ( (SpiUpdateOperationFailedException) next ).nextException;
                    return next;
                } else {
                    throw new NoSuchElementException( "No further exception" ); //$NON-NLS-1$
                }
            }

            public void remove( ) {

                throw new MoinUnsupportedOperationException( SpiFacilityMessages.REMOVEFROMEXCEPTIONITERATORNOTSUPPORTED );
            }

        };
    }
}
