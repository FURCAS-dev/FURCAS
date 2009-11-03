package com.sap.tc.moin.repository.spi.ps;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;

/**
 * Instances of {@link SpiClass} represent a {@link MofClass} in a metamodel.
 */
public interface SpiClass extends SpiType {

    /**
     * Returns a list of all direct or inherited {@link Attribute attributes} of
     * this class.
     * 
     * @return a list of all direct or inherited attributes of this class
     */
    public List<String> get___AttributeNames( );

    /**
     * Returns whether the attribute with the specified name is multi-valued or
     * not.
     * 
     * @param attributeName the name of the attribute in question
     * @return whether the attribute with the specified name is multi-valued or
     * not
     * @throws IllegalArgumentException if the class contains no attribute with
     * the specified name
     */
    public boolean is___MultiValuedAttribute( String attributeName );

    /**
     * Returns whether the attribute with the specified name is object-valued or
     * not.
     * 
     * @param attributeName the name of the attribute in question
     * @return whether the attribute with the specified name is object-valued or
     * not
     * @throws IllegalArgumentException if the class contains no attribute with
     * the specified name
     */
    public boolean is___ObjectValuedAttribute( String attributeName );

    /**
     * Returns the type of the attribute with the specified name, given as an
     * enumeration value of type {@link SpiAttributeTypeEnum}. If more detailed
     * information about the attribute type is required, please use
     * {@link #get___AttributeType(String)} instead.
     * 
     * @param attributeName the name of the attribute in question
     * @return the enumeration value denoting the type of the attribute with the
     * specified name
     * @throws IllegalArgumentException if the class contains no attribute with
     * the specified name
     */
    public SpiValueTypeEnum get___AttributeTypeAsEnum( String attributeName );

    /**
     * Returns the {@link SpiType type} of the attribute with the specified
     * name.
     * 
     * @param attributeName the name of the attribute in question
     * @return the type of the attribute with the specified name
     * @throws IllegalArgumentException if the class contains no attribute with
     * the specified name
     */
    public SpiType get___AttributeType( String attributeName );

    /**
     * Returns the MOF id of the attribute with the specified name. This
     * information might be of interest for a custom serializer when serializing
     * external values of object-valued attributes.
     * 
     * @param attributeName the name of the attribute in question
     * @return the MOF id of the attribute with the specified name
     * @throws IllegalArgumentException if the class contains no attribute with
     * the specified name
     */
    public String get___AttributeMofId( String attributeName );
}