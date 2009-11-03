package com.sap.tc.moin.repository.spi.ps.parser;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiElementBase;
import com.sap.tc.moin.repository.spi.ps.SpiStructuredValueBase;
import com.sap.tc.moin.repository.spi.ps.SpiType;

/**
 * The interface {@link SpiElement} represents a MOIN model element in the
 * parser scenario. It offers methods for retrieving the model element's
 * {@link SpiClass class} and for setting the values of the model element's
 * attributes. Instances of {@link SpiElement} cannot be created by the parser
 * author, but are returned from calls to
 * {@link SpiParserCallback#addElement(SpiType, String)}.
 */
public interface SpiElement extends SpiElementBase {

    /**
     * Adds a value to the primitive- or enumeration-typed attribute given by
     * its name. The value has to be passed as a String and internally gets
     * converted to the correct type according to the metamodel (e.g.
     * <code>boolean, int, double</code>, or the correct enumeration
     * literal).
     * <p>
     * Note that the parser author does not need to care for the attribute's
     * multiplicity: if the attribute is multiplicity-one, the value is simply
     * set, and in the case of multiplicity-many, the value gets appended to the
     * already existing list of values reported ealier by the parser.
     * 
     * @param attributeName the name of the attribute for which a value should
     * be added
     * @param primitiveOrEnumValue the String representation of the attribute
     * value; must not be <code>null</code>
     * @throws IllegalArgumentException if <code>primitiveOrEnumValue</code>
     * is <code>null</code>
     */
    public void add___PrimitiveOrEnumerationValue( String attributeName, String primitiveOrEnumValue );

    /**
     * Adds a value to the structure-typed attribute given by its name. The
     * value must have been created via
     * {@link SpiParserCallback#createStructuredValue()} and filled using the
     * methods of {@link SpiStructuredValueBase}.
     * <p>
     * Note that the parser author does not need to care for the attribute's
     * multiplicity: if the attribute is multiplicity-one, the value is simply
     * set, and in the case of multiplicity-many, the value gets appended to the
     * already existing list of values reported ealier by the parser.
     * 
     * @param attributeName the name of the attribute for which a value should
     * @param structuredValue the structured attribute value; must not be
     * <code>null</code>
     * @throws IllegalArgumentException if <code>structuredValue</code> is
     * <code>null</code>
     */
    public void add___StructuredValue( String attributeName, SpiStructuredValueBase structuredValue );

    /**
     * Adds a value to the object-typed attribute given by its name. The value
     * must have been created via
     * {@link SpiParserCallback#addElement(SpiType, String)}. Note that its
     * attributes do not need to be populated yet, this can still be done later
     * on.
     * <p>
     * Note that the parser author does not need to care for the attribute's
     * multiplicity: if the attribute is multiplicity-one, the value is simply
     * set, and in the case of multiplicity-many, the value gets appended to the
     * already existing list of values reported ealier by the parser.
     * 
     * @param attributeName the name of the attribute for which a value should
     * @param element the {@link SpiElement} that is the value of the attribute;
     * must not be <code>null</code>
     * @throws IllegalArgumentException if <code>element</code> is
     * <code>null</code>
     */
    public void add___ElementValue( String attributeName, SpiElement element );

    /**
     * Adds a value to the object-typed attribute given by its name. This method
     * has to be used if the value resides in a different artifact, i.e. it is
     * not contained in the currently parsed stream.
     * <p>
     * Note that the parser author does not need to care for the attribute's
     * multiplicity: if the attribute is multiplicity-one, the value is simply
     * set, and in the case of multiplicity-many, the value gets appended to the
     * already existing list of values reported ealier by the parser.
     * 
     * @param attributeName the name of the attribute for which a value should
     * @param lriOfExternalElement The {@link SpiElement} that is the value of
     * the attribute, given by its {@link LRI}. Must not be <code>null</code>.
     * @throws IllegalArgumentException if <code>mofIdOfExternalElement</code>
     * is <code>null</code>
     */
    public void add___ExternalElementValue( String attributeName, LRI lriOfExternalElement );
}