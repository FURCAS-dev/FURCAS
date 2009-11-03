package com.sap.tc.moin.repository.core.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.DeepCopyMap;
import com.sap.tc.moin.repository.DeepCopyMappingEntry;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;

/**
 * The internal copy map provides read and write functionality.
 * 
 * @author d046918
 */
public class DeepCopyMapImpl implements DeepCopyMap {

    private Map<MRI, DeepCopyMappingEntry> copyMap;

    /**
     * Creates a mapping table object from a {@link java.util.Map}.
     * 
     * @param copyMap The internal mapping table
     */

    public DeepCopyMapImpl( ) {

        this.copyMap = new HashMap<MRI, DeepCopyMappingEntry>( );
    }


    public DeepCopyMappingEntry get( RefObject element ) {

        DeepCopyMappingEntry result = null;
        if ( copyMap.containsKey( element.get___Mri( ) ) ) {
            result = copyMap.get( element.get___Mri( ) );
        }
        return result;
    }

    public boolean containsKey( RefObject element ) {

        return copyMap.containsKey( element.get___Mri( ) );
    }

    public DeepCopyMappingEntry put( RefObject key, DeepCopyMappingEntry value ) {

        return copyMap.put( key.get___Mri( ), value );
    }

    public Set<Entry<MRI, DeepCopyMappingEntry>> entrySet( ) {

        return copyMap.entrySet( );
    }


    /**
     * Creates a printable version of the mapping table
     * 
     * @param copyMap The mapping table that is to be serialized
     * @return
     */

    @Override
    public String toString( ) {

        StringBuilder sb = new StringBuilder( );
        sb.append( "Mapping Table:" + "\n" ); //$NON-NLS-1$//$NON-NLS-2$
        sb.append( "---------------------+------------+------------+--------------------" + "\n" ); //$NON-NLS-1$//$NON-NLS-2$
        sb.append( "Original Element     | Original P | Modified P | Target" + "\n" ); //$NON-NLS-1$//$NON-NLS-2$
        sb.append( "---------------------+------------+------------+--------------------" + "\n" ); //$NON-NLS-1$//$NON-NLS-2$
        for ( Entry<MRI, DeepCopyMappingEntry> mapEntry : copyMap.entrySet( ) ) {
            sb.append( fixedWidthString( ( mapEntry.getKey( ).toString( ) ), 20 ) );
            sb.append( " | " ); //$NON-NLS-1$
            sb.append( fixedWidthString( mapEntry.getValue( ).getOriginalPolicy( ).getDeepCopyPolicyOption( ).toString( ), 10 ) );
            sb.append( " | " ); //$NON-NLS-1$
            sb.append( fixedWidthString( mapEntry.getValue( ).getModifiedPolicy( ).getDeepCopyPolicyOption( ).toString( ), 10 ) );
            sb.append( " | " ); //$NON-NLS-1$
            if ( mapEntry.getValue( ).getMappingTarget( ) != null ) {
                sb.append( fixedWidthString( ( (String) ( (RefObjectImpl) mapEntry.getValue( ).getMappingTarget( ) ).refGetValue( null, "name" ) ), 20 ) ); //$NON-NLS-1$
            }
            sb.append( "\n" ); //$NON-NLS-1$
        }
        return sb.toString( );
    }

    /**
     * Trim a String to a fixed Length
     * 
     * @param originalString
     * @param length
     * @return
     */

    private String fixedWidthString( String originalString, int length ) {

        String result = ""; //$NON-NLS-1$
        if ( originalString.length( ) == length ) {
            result = originalString;
        } else if ( originalString.length( ) > length ) {
            result = originalString.substring( 0, length - 1 );
        } else {
            result = originalString;
            while ( result.length( ) < length ) {
                result = result + " "; //$NON-NLS-1$
            }
        }
        return result;
    }

}
