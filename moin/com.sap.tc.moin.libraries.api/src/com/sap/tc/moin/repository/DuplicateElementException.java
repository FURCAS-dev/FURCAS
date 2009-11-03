package com.sap.tc.moin.repository;

import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.JmiExceptionMessages;

/**
 * Thrown if multiple instances of the same model element are found and it can
 * therefore not be determined which instance to use. This can occur if
 * partitions have the wrong sync state and a repartitioned model element is
 * seen twice.
 * <p>
 * The exception provides a {@link List list} of {@link MRI}s representing the
 * different instances of the same model element.
 */
public class DuplicateElementException extends InconsistentModelException {

    private static final long serialVersionUID = 1L;

    /**
     * List of MRIs representing the different instances of the same model
     * element
     */
    private volatile List<MRI> myMris;

    private static String mrisToString( List<MRI> mris ) {

        StringBuilder msg = new StringBuilder( );
        for ( MRI mri : mris ) {
            msg.append( mri + ", " ); //$NON-NLS-1$
        }
        return msg.toString( );

    }

    /**
     * Getter for the list of MRIs
     * 
     * @return the list of MRIs
     */
    public List<MRI> getMris( ) {

        return this.myMris;
    }

    /**
     * @param mris list of MRIs for the ambiguous model element
     */
    public DuplicateElementException( List<MRI> mris ) {

        super( JmiExceptionMessages.DUPLICATEELEMENTS, mrisToString( mris ) );
        this.myMris = Collections.unmodifiableList( mris );
    }


}
