package com.sap.tc.moin.repository;

import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.JmiExceptionMessages;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Additional output for detecting the remaining elements
 */
public class NullPartitionNotEmptyException extends PartitionException {

    private static final long serialVersionUID = 1L;

    /**
     * @param partition
     */
    public NullPartitionNotEmptyException( ModelPartition partition ) {

        super( JmiExceptionMessages.TRANSIENTPARTITIONMUSTBEEMPTY, partition.getPri( ), partition.getPri( ), getMris( partition ) );
    }

    private static String getMris( ModelPartition partition ) {

        if ( partition != null ) {
            // TODO we should consider removing this
            StringBuffer result = new StringBuffer( );
            for ( Iterator<Partitionable> it = partition.getElements( ).iterator( ); it.hasNext( ); ) {
                RefObject refObject = (RefObject) it.next( );
                result.append( "(MRI: " ); //$NON-NLS-1$
                result.append( ( (Partitionable) refObject ).get___Mri( ) );
                result.append( ", Type: " ); //$NON-NLS-1$
                result.append( getQualifiedName( (MofClass) refObject.refMetaObject( ) ) );
                result.append( ")" ); //$NON-NLS-1$
                if ( it.hasNext( ) ) {
                    result.append( ", " ); //$NON-NLS-1$
                }
            }
            result.append( " }" ); //$NON-NLS-1$
            return result.toString( );
        }

        return ""; //$NON-NLS-1$
    }

    private static String getQualifiedName( MofClass mc ) {

        List<String> qualifiedName = mc.getQualifiedName( );
        StringBuffer result = new StringBuffer( );
        for ( Iterator<String> i = qualifiedName.iterator( ); i.hasNext( ); ) {
            String segment = i.next( );
            result.append( segment );
            if ( i.hasNext( ) ) {
                result.append( "." ); //$NON-NLS-1$
            }
        }
        return result.toString( );
    }

}
