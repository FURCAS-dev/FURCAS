package com.sap.tc.moin.repository.spi.ps.parser;

import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.tc.moin.repository.spi.ps.SpiStructuredValueBase;

/**
 * Represents the value of an attribute of type {@link StructureType}. It has
 * methods for setting the values of structure fields and methods for retrieving
 * the value of a specific structure field (the latter ones inherited from
 * {@link SpiStructuredValueBase}). Instances of this interface have to be
 * created using {@link SpiParserCallback#createStructuredValue()}.
 */
public interface SpiStructuredValue extends SpiStructuredValueBase {

    /**
     * Sets the primitive or enumeration value of the structure field with the
     * specified name to the given value. The value has to be given as a String,
     * which internally gets converted to the corresponding primitive value or
     * enumeration literal.
     * 
     * @param fieldName the name of the structure field
     * @param value the value to set
     */
    public void set___FieldValue( String fieldName, String value );

    /**
     * Sets the structured value of the structure field with the specified name
     * to the given value. The value has to be given as an instance of
     * {@link SpiStructuredValue}, which has to be created beforehand using
     * {@link SpiParserCallback#createStructuredValue()}.
     * 
     * @param fieldName the name of the structure field
     * @param value the value to set
     */
    public void set___FieldValue( String fieldName, SpiStructuredValue value );
}
