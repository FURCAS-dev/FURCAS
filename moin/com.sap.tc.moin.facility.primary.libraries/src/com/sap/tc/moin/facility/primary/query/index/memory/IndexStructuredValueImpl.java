package com.sap.tc.moin.facility.primary.query.index.memory;

import java.util.Collection;
import java.util.Collections;

import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.parser.SpiStructuredValue;

public final class IndexStructuredValueImpl implements SpiStructuredValue {

    public void set___FieldValue( String fieldName, String value ) {

        // Do nothing, we are not interested in attributes at all.
    }

    public void set___FieldValue( String fieldName, SpiStructuredValue value ) {

        // Do nothing, we are not interested in attributes at all.
    }

    public Collection<String> get___FieldNames( ) {

        return Collections.emptySet( );
    }

    public Object get___FieldValue( String fieldName ) {

        return null;
    }

    public SpiStructureType get___Type( ) {

        return null;
    }
}