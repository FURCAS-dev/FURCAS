package com.sap.tc.moin.repository.spi.ps;

/**
 * The interface {@link SpiElementBase} is the abstraction of a MOIN model
 * element. It is the base interface for the parser / serializer specific
 * sub-interfaces.
 */
public interface SpiElementBase {

    /**
     * Returns the element's {@link SpiClass type}. Note that the type is
     * guaranteed to exist in the metamodel.
     * 
     * @return the type of this element
     */
    public SpiClass get___Type( );

    /**
     * Returns the element's MOF id.
     */
    public String get___MofId( );

    /**
     * Returns the current value of the element's attribute with the specified
     * name. The return value can be one of the following:
     * <ul>
     * <li>{@link String}, for attributes of type {@link PrimitiveType} or
     * {@link EnumerationType}</li>
     * <li>{@link SpiStructuredValue}, for attributes of type
     * {@link StructureType}</li>
     * <li>{@link SpiElement}, for object-valued attributes whose value is an
     * element from the current partition</li>
     * <li>{@link LRI}, for object-valued attributes whose value is an element
     * some other partition</li>
     * <li>a {@link Collection} of any of the preceding types, if the attribute
     * is {@link SpiClass#is___MultiValuedAttribute(String) multi-valued}</li>
     * </ul>
     * 
     * @param attributeName the name of the requested attribute
     * @return the current value of the element's attribute with the specified
     * name
     */
    public Object get___AttributeValue( String attributeName );
}