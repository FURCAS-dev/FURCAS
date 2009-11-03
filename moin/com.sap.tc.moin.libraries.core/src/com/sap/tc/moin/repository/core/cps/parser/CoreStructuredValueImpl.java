package com.sap.tc.moin.repository.core.cps.parser;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.parser.SpiStructuredValue;

public final class CoreStructuredValueImpl implements SpiStructuredValue {

    private final SpiStructureType structureType;

    private Map<String /* fieldName */, Object /* fieldValue */> fieldValues = new LinkedHashMap<String, Object>( );

    public CoreStructuredValueImpl( ) {

        structureType = null; // not known if this constructor is used
    }

    public CoreStructuredValueImpl( SpiStructureType structureType ) {

        this.structureType = structureType;
    }

    public SpiStructureType get___Type( ) {

        return structureType;
    }

    public void set___FieldValue( String fieldName, String value ) {

        fieldValues.put( fieldName, value );
    }

    public void set___FieldValue( String fieldName, SpiStructuredValue value ) {

        fieldValues.put( fieldName, value );
    }

    public Collection<String> get___FieldNames( ) {

        return Collections.unmodifiableCollection( fieldValues.keySet( ) );
    }

    public Object get___FieldValue( String fieldName ) {

        return fieldValues.get( fieldName );
    }

    private void toStringRecursive( StringBuilder sb, CoreStructuredValueImpl structuredValue, String enclosingField ) {

        for ( Iterator<Entry<String, Object>> it = structuredValue.fieldValues.entrySet( ).iterator( ); it.hasNext( ); ) {
            Entry<String, Object> entry = it.next( );
            String fieldName = entry.getKey( );
            Object fieldValue = entry.getValue( );
            if ( fieldValue == null ) {
                continue;
            }
            if ( fieldValue instanceof SpiStructuredValue ) {
                if ( enclosingField != null ) {
                    toStringRecursive( sb, (CoreStructuredValueImpl) fieldValue, enclosingField + "." + fieldName ); //$NON-NLS-1$
                } else {
                    toStringRecursive( sb, (CoreStructuredValueImpl) fieldValue, fieldName );
                }
            } else {
                String value = (String) fieldValue;
                if ( enclosingField != null ) {
                    sb.append( enclosingField + "." + fieldName + "='" + value + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                } else {
                    sb.append( fieldName + "='" + value + "'" ); //$NON-NLS-1$ //$NON-NLS-2$
                }
                if ( it.hasNext( ) ) {
                    sb.append( " " ); //$NON-NLS-1$
                }
            }
        }
    }

    @Override
    public String toString( ) {

        StringBuilder sb = new StringBuilder( "{" ); //$NON-NLS-1$
        toStringRecursive( sb, this, null /* enclosingField */);
        sb.append( "}" ); //$NON-NLS-1$
        return sb.toString( );
    }
}
