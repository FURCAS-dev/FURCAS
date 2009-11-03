package com.sap.tc.moin.repository.spi.ps.parser;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.tc.moin.repository.spi.ps.SpiValueTypeEnum;

/**
 * Instances of this class represent {@link Attribute attributes} of
 * {@link MofClass MofClasses}, storing all relevant information for a
 * successful parsing process.
 */
public interface SpiAttributeInfo {

    /**
     * Returns the attribute's name.
     * 
     * @return the attribute's name
     */
    public String getName( );

    /**
     * Returns the attribute's type.
     * 
     * @return the attribute's type
     */
    public SpiValueTypeEnum getType( );

    /**
     * Returns the attribute's MOF id.
     * 
     * @return the attribute's MOF id
     */
    public String getMofId( );

    /**
     * Returns whether the attribute is multi-valued.
     * 
     * @return whether the attribute is multi-valued
     */
    public boolean isMultiValued( );

    /**
     * Returns whether the attribute is object-valued.
     * 
     * @return whether the attribute is object-valued
     */
    public boolean isObjectValued( );
}