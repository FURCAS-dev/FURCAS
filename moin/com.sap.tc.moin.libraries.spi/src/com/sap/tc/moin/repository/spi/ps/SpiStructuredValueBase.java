package com.sap.tc.moin.repository.spi.ps;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.StructureType;

/**
 * Represents the value of an attribute of type {@link StructureType}. It has
 * methods for retrieving the structure fields and their values.
 */
public interface SpiStructuredValueBase {

    /**
     * Returns the names of all currently existing fields. Note that the
     * returned collection is not modifiable.
     * 
     * @return the unmodifiable collection of names of all currently existing
     * fields
     */
    public Collection<String> get___FieldNames( );

    /**
     * Returns the current value for the structure field with the specified
     * name.
     * 
     * @param fieldName the name of the requested structure field
     * @return the field value, which is either an instance of {@link String} or
     * an instance of {@link SpiStructuredValueBase}.
     */
    public Object get___FieldValue( String fieldName );

    /**
     * Returns an instance of {@link SpiStructureType} representing the
     * {@link StructureType} which is the meta object of this structured value.
     * 
     * @param an instance of SpiStructureType representing the StructureType
     * which is the meta object of this structured value
     */
    public SpiStructureType get___Type( );
}
